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
}
