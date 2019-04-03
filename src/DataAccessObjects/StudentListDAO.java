package DataAccessObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; 

public class StudentListDAO {
	
	public List<Etudiant> getStudentList() {
		
	  List<Etudiant> etudiants = new ArrayList<Etudiant>();
	  Connection connection = DBManager.getInstance().getConnection();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id,sexe,nom,prenom FROM Etudiant");
            
            while(rs.next())
            {
          	  String id = rs.getString("id");
                String sexe = rs.getString("sexe");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                Etudiant etudiant = new Etudiant(id,sexe,nom,prenom,null,null,0,null,null,0,null,0,null,null);
                etudiants.add(etudiant);
             }
         } 
         catch (SQLException e) 
         {
             e.printStackTrace();
         }
         return etudiants;
     }
		
	public Etudiant getStudentDetail(String searchText) {
		
		  Connection connection = DBManager.getInstance().getConnection();
		  List<Etudiant> etudiants = new ArrayList<Etudiant>();
		  String[] data = searchText.split(" ", 2);
		  if(data.length != 2) {
			  return null;
		  }
		  String nomEtudiant = data[0];
		  String prenomEtudiant = data[1];
      try 
      {
    	  PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Etudiant where Etudiant.nom = ? AND Etudiant.prenom = ?");	
    	  pstmt.setString(1, nomEtudiant);
    	  pstmt.setString(2, prenomEtudiant);
    	  ResultSet rs = pstmt.executeQuery();
          while(rs.next())
          {
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
              etudiants.add(etudiant);
          }    
      }
       catch (SQLException e) 
       {
           e.printStackTrace();
       }
      if(etudiants.isEmpty())
    	  return null;
      else
    	  return etudiants.get(0);
   }
	
	public SQLException updateStudent(ArrayList<String> updateProperties) {
		if(updateProperties.size() != 14 || updateProperties.get(1).contentEquals("") || updateProperties.get(2).contentEquals("")) {
			return new SQLException();
		}
		System.out.println("Beginning update");
		Connection connection = DBManager.getInstance().getConnection();
		try{
	    	  PreparedStatement pstmt = connection.prepareStatement("UPDATE Etudiant SET Etudiant.sexe = ?, Etudiant.nom = ?, Etudiant.prenom = ?, "
	    	  		+ "Etudiant.dateNaissance = ?, Etudiant.serieBac = ?,Etudiant.anneeBac = ?, Etudiant.mentionBac = ?, Etudiant.diplome = ?,"
	    	  		+ "Etudiant.anneeDiplome = ?, Etudiant.villeDiplome = ?, Etudiant.inscription = ?,Etudiant.courrielPro = ?, Etudiant.courrielPerso = ? WHERE Etudiant.Id = ?");	
	    	  for(int i = 1; i < updateProperties.size(); i++) {
	    		  pstmt.setString(i, updateProperties.get(i));
	    	  }
	    	  pstmt.setString(14,updateProperties.get(0)); // to get id 
	    	  pstmt.executeUpdate();
	    	  System.out.println("Update done");
	    	  return null;
	      }
		catch (SQLException e) 
	       {
	           e.printStackTrace();
	           return e;
	       }
	}
	
	public SQLException addStudent(ArrayList<String> parameters) {
		
		Connection connection = DBManager.getInstance().getConnection();
		
		
		try{
	    	  PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Etudiant (id,sexe, nom, prenom, dateNaissance, serieBac,"
	    	  		+ "anneeBac, mentionBac, diplome, anneeDiplome, villeDiplome, inscription,courrielPro, courrielPerso) VALUES "
	    	  		+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");	
	    	  for(int i = 0; i<parameters.size();i++) {
	    		  pstmt.setString(i+1, parameters.get(i));
	    	  }
	    	  pstmt.executeUpdate();
	    	  System.out.println("Student added");
	    	  return null;
	      }
		catch (SQLException e) 
	       {
	           e.printStackTrace();
	           return e;
	       }
		
	}
	
	public void deleteSudent(Etudiant etudiant) {
		
		Connection connection = DBManager.getInstance().getConnection();
		String id = etudiant.getId();
		
		try{
	    	  PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Etudiant WHERE Etudiant.id = ?");   	 
	    	  pstmt.setString(1,id);
	    	  pstmt.executeUpdate();
	    	  System.out.println("Student deleted");
	      }
		catch (SQLException e) 
	       {
	           e.printStackTrace();
	       }
		
	}
}


