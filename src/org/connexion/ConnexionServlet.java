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
		Connection connection = DBManagerAuth.getInstance().getConnection();
		boolean userFound = false; 
		try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, mdp, droits FROM Utilisateur");
            while(!userFound && rs.next()) {
	            if(rs.getString("id").contentEquals(request.getParameter("login")) && rs.getString("mdp").contentEquals(request.getParameter("password"))) {
	      	  		userFound = true;
	      	  	}
            }
            if(userFound) {
        		User user = new User(rs.getString("id"), rs.getString("mdp"), rs.getString("droits"));
            	request.getSession().setAttribute("user", user);
            	if(user.getRights().equals("admin")) {
                	response.sendRedirect("admin/Menu");
            	} else if(user.getRights().equals("editor")) {
            		response.sendRedirect("editor/Menu");
            	} else {
            		response.sendRedirect("standard/Menu");
            	}
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
