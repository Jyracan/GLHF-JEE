package DataAccessObjects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AuthentificationDAO {
	
	public HashMap<String,String> getIdentification() {
		
		HashMap<String,String> identification = new HashMap<String,String>(); //identification represented by a login and a password
		Connection connection = DBManagerAuth.getInstance().getConnection();
		try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id,mdp FROM Authentification");
            
            while(rs.next())
            {
          	  String id = rs.getString("id");
                String mdp = rs.getString("mdp");
                identification.put(id,mdp);
             }
         } 
         catch (SQLException e) 
         {
             e.printStackTrace();
         }
         return identification;
	}

}
