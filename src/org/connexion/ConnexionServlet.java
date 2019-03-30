package org.connexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		User user = new User(request.getParameter("login"), request.getParameter("password"), "12", "admin");
		Connection connection = DBManagerAuth.getInstance().getConnection();
		boolean test = false; 
		try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id FROM Utilisateur");
            System.out.println(rs);
            if( rs.getString("id") != request.getParameter("login")) {
      	  		test = true;
      	  	}
            /*while(rs.next() && rs.getString("id") != request.getParameter("login"))
            {
          	  	if( rs.getString("id") != request.getParameter("login")) {
          	  		test = true;
          	  	}
            }*/
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
