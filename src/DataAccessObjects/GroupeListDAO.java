package DataAccessObjects;

import java.sql.Connection;
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
}
