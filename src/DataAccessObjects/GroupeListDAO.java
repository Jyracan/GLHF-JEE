package DataAccessObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupeListDAO {
	public List<Groupe> getGroupeList() {
		
		  List<Groupe> groupes = new ArrayList<Groupe>();
		  Connection connection = DBManager.getInstance().getConnection();
	        try 
	        {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT idGroupe,nomGroupe,redacteur FROM Groupe");
	            
	            while(rs.next())
	            {
	          	  	String idGroupe = rs.getString("idGroupe");
	                String nomGroupe = rs.getString("nomGroupe");
	                String redacteur = rs.getString("redacteur");
	                Groupe groupe = new Groupe(idGroupe,nomGroupe,redacteur);
	                groupes.add(groupe);
	             }
	         } 
	         catch (SQLException e) 
	         {
	             e.printStackTrace();
	         }
	         return groupes;
	}
	
	
	public Groupe getGroupeDetail(String searchText) {
		
		  Connection connection = DBManager.getInstance().getConnection();
		  List<Groupe> groupes = new ArrayList<Groupe>();
		  String[] data = searchText.split(" ", 1);
		  String idGroupe = data[0];
    try 
    {
  	  PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Groupe where Groupe.idGroupe = ?");	
  	  pstmt.setString(1, idGroupe);
  	  ResultSet rs = pstmt.executeQuery();
        while(rs.next())
        {
      	   String nomGroupe = rs.getString("nomGroupe");
      	   String redacteur = rs.getString("redacteur");            
            Groupe groupe = new Groupe(idGroupe,nomGroupe,redacteur);
            groupes.add(groupe);
        }    
    }
     catch (SQLException e) 
     {
         e.printStackTrace();
     }
    if(groupes.isEmpty())
  	  return null;
    else
  	  return groupes.get(0);
	}
	

	public List<Etudiant> getMember (String searchText){
		
		List<Etudiant> listStudent = new ArrayList<Etudiant>();
		Connection connection = DBManager.getInstance().getConnection();
		List<Groupe> groupes = new ArrayList<Groupe>();
		String[] data = searchText.split(" ", 1);
		String idGroupe = data[0];
		  try {
			  PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Etudiant JOIN Etudiant_has_Groupe ON id = Etudiant_id WHERE Groupe_idGroupe = ?");	
			  pstmt.setString(1, idGroupe);
			  ResultSet rs = pstmt.executeQuery();
			  while(rs.next()){
				  String id = rs.getString("id");
				  String sexe = rs.getString("sexe");
				  String nom = rs.getString("nom");
				  String prenom = rs.getString("prenom");
				  String dateNaissance = rs.getString("dateNaissance");
				  String serieBac = rs.getString("serieBac");
				  int anneeBac = Integer.parseInt(rs.getString("anneeBac"));
				  String mentionBac = rs.getString("mentionBac");
				  String diplome = rs.getString("diplome");
				  int anneeDiplome = Integer.parseInt(rs.getString("anneeDiplome"));
				  String villeDiplome = rs.getString("villeDiplome");
				  int inscription = Integer.parseInt(rs.getString("inscription"));
				  String courrielPro = rs.getString("courrielPro");
				  String courrielPerso = rs.getString("courrielPerso");
			      Etudiant etudiant = new Etudiant(id,sexe,nom,prenom,dateNaissance,serieBac,anneeBac,mentionBac,diplome,anneeDiplome,villeDiplome,inscription,courrielPro,courrielPerso);
			      listStudent.add(etudiant);
			  }    
		  }
		   catch (SQLException e) {
		       e.printStackTrace();
		   }
		  if(listStudent.isEmpty())
			  return null;
		  else
			return listStudent;
	}
	
	public void supprEtu (String idEtudiant, String idGroupe, String redacteur) {
		Connection connection = DBManager.getInstance().getConnection();
		try {
			if(verifyEditor(idGroupe, redacteur)) {
				PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Etudiant_has_Groupe WHERE Groupe_idGroupe=? AND Etudiant_id=?");	
				pstmt.setString(1, idGroupe);
				pstmt.setString(2, idEtudiant);
				pstmt.executeUpdate();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void ajtEtu (String idEtudiant, String idGroupe, String redacteur) {
		Connection connection = DBManager.getInstance().getConnection();
		try {
			if(verifyEditor(idGroupe, redacteur)) {
				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Etudiant_has_Groupe (Groupe_idGroupe,Etudiant_id)  VALUES (? , ?)");
				pstmt.setString(1, idGroupe);
				pstmt.setString(2, idEtudiant);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void creerGroupe(String nomGroupe, String redacteur) {
		Connection connection = DBManager.getInstance().getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Groupe (nomGroupe,redacteur)  VALUES (? , ?)");
			pstmt.setString(1, nomGroupe);
			pstmt.setString(2, redacteur);
			pstmt.executeUpdate();
			}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void supprGroupe (String nomGroupe, String redacteur) {
		Connection connection = DBManager.getInstance().getConnection();
		String id_group="";
		ResultSet rs;
		try {
			Statement statementGroupe = connection.createStatement();
			if(redacteur.contentEquals("")) {
				rs = statementGroupe.executeQuery("SELECT idGroupe FROM Groupe WHERE nomGroupe =\""+nomGroupe +"\";");
			} else {
				rs = statementGroupe.executeQuery("SELECT idGroupe FROM Groupe WHERE nomGroupe =\""+nomGroupe +"\" AND redacteur = \""+redacteur+"\";");
			}
		    
		    if(rs.next()) {
		    	id_group=rs.getString("idGroupe");
    
	        	Statement statement1 = connection.createStatement();
	        	Statement statement2 = connection.createStatement();
	        	Statement statement3 = connection.createStatement();
	        	String query = "delete from Groupe where nomGroupe = \"" + nomGroupe +"\";";
	        	String queryStudent = "delete from Etudiant_has_Groupe where Groupe_idGroupe =\""+id_group+"\";";
	        	String queryGroup = "delete from Groupe_has_Groupe where idGroupeAscendant =\""+id_group+"\" or idGroupeDescendant =\""+id_group+"\";";
	        	System.out.println(query);
	        	System.out.println(queryStudent);
	        	System.out.println(queryGroup);
	        	statement1.executeUpdate(queryStudent);
	        	statement2.executeUpdate(queryGroup);
	        	statement3.executeUpdate(query);
			}
       	
       }
       catch (SQLException e) 
       {
           e.printStackTrace();
       }
	}
	
	public List<Groupe> getGroupeSons(String id) {
		List<Groupe> groupes = new ArrayList<Groupe>();
		Connection connection = DBManager.getInstance().getConnection();
	    try {
	    	PreparedStatement pstmt = connection.prepareStatement("SELECT idGroupe,nomGroupe,redacteur FROM Groupe, Groupe_has_Groupe WHERE idGroupeAscendant = ? AND idGroupe = idGroupeDescendant");
	    	pstmt.setString(1, id);
	        ResultSet rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	String idGroupe = rs.getString("idGroupe");
	            String nomGroupe = rs.getString("nomGroupe");
	            String redacteur = rs.getString("redacteur");
	            Groupe groupe = new Groupe(idGroupe,nomGroupe,redacteur);
	            groupes.add(groupe);
	        }
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return groupes;
	}
	
	public void addGrpToGrp(String idFather, String idSon, String redacteur) {
		if(verifyEditor(idFather, redacteur)) {
			Connection connection = DBManager.getInstance().getConnection();
			PreparedStatement pstmt;
			try {
				//insertion dans group_has_groupe
				pstmt = connection.prepareStatement("INSERT INTO Groupe_has_Groupe (idGroupeAscendant,idGroupeDescendant)  VALUES (? , ?)");
				pstmt.setString(1, idFather);
				pstmt.setString(2, idSon);
				pstmt.executeUpdate();
			
				//insertion des étudiants dans le groupe
				pstmt = connection.prepareStatement("SELECT id FROM Etudiant,Etudiant_has_Groupe WHERE id = Etudiant_id AND Groupe_idGroupe = ?");
				pstmt.setString(1, idSon);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					ajtEtu(rs.getString("id"), idFather, redacteur);
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delGrpToGrp(String idFather, String idSon, String redacteur) {
		if(verifyEditor(idFather, redacteur)) {
			Connection connection = DBManager.getInstance().getConnection();
			PreparedStatement pstmt;
			try {
				//suppression des étudiants du groupe fils dans le groupe père
				pstmt = connection.prepareStatement("SELECT id FROM Etudiant,Etudiant_has_Groupe WHERE id = Etudiant_id AND Groupe_idGroupe = ?");
				pstmt.setString(1, idSon);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					supprEtu(rs.getString("id"), idFather, redacteur);
				}
			
				//suppression de groupe_has_groupe
				pstmt = connection.prepareStatement("DELETE FROM Groupe_has_Groupe WHERE idGroupeAscendant = ? AND idGroupeDescendant = ?");
				pstmt.setString(1, idFather);
				pstmt.setString(2, idSon);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean verifyEditor(String idGroupe, String editor) {
		Connection connection = DBManager.getInstance().getConnection();
		ResultSet rs;
		Statement statementGroupe;
		try {
			statementGroupe = connection.createStatement();
			if(editor.contentEquals("")) {
				rs = statementGroupe.executeQuery("SELECT * FROM Groupe WHERE idGroupe =\""+idGroupe+"\";");
			} else {
				rs = statementGroupe.executeQuery("SELECT * FROM Groupe WHERE idGroupe =\""+idGroupe+"\" AND redacteur = \""+editor+"\";");
			}
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
