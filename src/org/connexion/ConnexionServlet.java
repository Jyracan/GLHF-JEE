package org.connexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DataAccessObjects.DBManagerAuth;
import sessionManagement.User;

public class ConnexionServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9007941498075904483L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/connexion.jsp");
		
		try {
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("###############################################################################");
		//System.out.println("Bonjour".indexOf("jr"));
		User user = new User(request.getParameter("login"), request.getParameter("password"), "12", "standard");
		request.getSession().setAttribute("user", user);
    	/*response.sendRedirect("Menu");*/
		Connection connection = DBManagerAuth.getInstance().getConnection();
		boolean test = false; 
		try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id FROM Utilisateur");
            System.out.println(request.getParameter("login"));
            while(rs.next()) {
	            System.out.println(rs.getString("id"));
	            if(rs.getString("id").contentEquals(request.getParameter("login"))) {
	      	  		test = true;
	      	  	}
            }
            System.out.println("test : "+ test);
            if(test) {
            	request.getSession().setAttribute("user", user);
            	response.sendRedirect("Menu");
            }
            else {
            	response.sendRedirect("Connexion");
            }
         } 
         catch (SQLException e) 
         {
             e.printStackTrace();
         }
	}
	
}
