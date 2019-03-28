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
	
	public void updateStudent(Etudiant etudiant) {
		
		System.out.println("Beginning update");
		deleteSudent(etudiant);
		addStudent(etudiant);
		System.out.println("Update done");
	}
	
	public void addStudent(Etudiant etudiant) {
		
		Connection connection = DBManager.getInstance().getConnection();
		ArrayList<String> parameters = new ArrayList<String>();
		
		parameters.add(etudiant.getId());
		parameters.add(etudiant.getSexe());
		parameters.add(etudiant.getNom());
		parameters.add(etudiant.getPrenom());
		parameters.add(etudiant.getDateNaissance());
		parameters.add(etudiant.getSerieBac());
		parameters.add(Integer.toString(etudiant.getAnneeBac()));
        parameters.add(etudiant.getMentionBac());
        parameters.add(etudiant.getDiplome());
        parameters.add(Integer.toString(etudiant.getAnneeDiplome()));
        parameters.add(etudiant.getVilleDiplome());
        parameters.add(Integer.toString(etudiant.getInscription()));
        parameters.add(etudiant.getCourrielPro());
        parameters.add(etudiant.getCourrielPerso());
		
		try{
	    	  PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Etudiant (id,sexe, nom, prenom, dateNaissance, serieBac,"
	    	  		+ "anneeBac, mentionBac, diplome, anneeDiplome, villeDiplome, inscription,courrielPro, courrielPerso) VALUES "
	    	  		+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");	
	    	  for(int i = 0; i<parameters.size();i++) {
	    		  pstmt.setString(i+1, parameters.get(i));
	    	  }
	    	  pstmt.executeUpdate();
	    	  System.out.println("Student added");
	      }
		catch (SQLException e) 
	       {
	           e.printStackTrace();
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


