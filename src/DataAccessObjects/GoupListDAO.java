package DataAccessObjects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List; 

public class GoupListDAO {

	
	public List<Etudiant> getGroupList() {
		
		  List<Etudiant> etudiants = new ArrayList<Etudiant>();
		  Connection connection = DBManager.getInstance().getConnection();
          try 
          {
              Statement statement = connection.createStatement();
              ResultSet rs = statement.executeQuery("SELECT * FROM Étudiant");
              while(rs.next())
              {
            	  String id = rs.getString("id");
                  String sexe = rs.getString("sexe");
                  String nom = rs.getString("nom");
                  String prenom = rs.getString("prenom");
                  Date dateNaissance = Date.parse(rs.getString("dateNaissance"));
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
           return etudiants;
       }
		
	}

}
