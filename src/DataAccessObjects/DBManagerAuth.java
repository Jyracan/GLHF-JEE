package DataAccessObjects;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class DBManagerAuth {

	private static DBManagerAuth instance;

	private ResourceBundle properties;

	private static String resourceBundle = "configAuth";

	private DBManagerAuth() {
		properties = ResourceBundle.getBundle(resourceBundle);

		try {
			Class.forName(properties.getString("DB_DRIVER"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static DBManagerAuth getInstance() {
		if (instance == null) {
			synchronized (DBManager.class) {
				instance = new DBManagerAuth();
			}
		}
		return instance;
	}

	public Connection getConnection() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(properties.getString("JDBC_URL"), properties.getString("DB_LOGIN"),
					properties.getString("DB_PASSWORD"));

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return connection;

	}

	public void cleanup(Connection connection, Statement stat, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * permet de tester la connexion à la DB
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Connection c = DBManagerAuth.getInstance().getConnection();
		if (c != null) {
			try {
				System.out.println("Connection to db : " + c.getCatalog());
				Properties p = c.getClientInfo();
				Enumeration<Object> keys = p.keys();
				while (keys.hasMoreElements()) {
					String key = (String) keys.nextElement();
					System.out.println(key + ":" + p.getProperty(key));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManagerAuth.getInstance().cleanup(c, null, null);
			}
		}
	}
}
