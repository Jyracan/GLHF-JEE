package org.connexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObjects.DBManagerAuth;
import sessionManagement.SessionVerifier;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginQuestionSecreteServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginQuestionSecrete.jsp");
		try {
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            	response.sendRedirect("QuestionSecrete");
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
	
	private void doProcess (HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginQuestionSecrete.jsp");
		try {
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	
}
