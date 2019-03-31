package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObjects.DBManagerAuth;
import sessionManagement.SessionVerifier;
import sessionManagement.User;


public class UsersManagementServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionVerifier.getInstance().verify(request, response)) {
			return;
		}
		
		ArrayList<User> users = new ArrayList<User>();
		Connection connection = DBManagerAuth.getInstance().getConnection();
		try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id,droits FROM Utilisateur");
            
            while(rs.next())
            {
          	  	users.add(new User(rs.getString("id"), null, rs.getString("droits")));
            }
         } catch (SQLException e) {
             e.printStackTrace();
         }
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/UsersListe.jsp");
		request.setAttribute("usersList", users);
		try {
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
