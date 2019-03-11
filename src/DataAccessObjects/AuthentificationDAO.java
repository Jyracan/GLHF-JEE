package DataAccessObjects;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AuthentificationDAO {
	
	public List<String> getIdentification() {
		
		List<String> identification = new ArrayList<String>(); //identification represented by a login and a password
		Connection connection = DBManagerAuthentification.getInstance().getConnection();
	}

}
