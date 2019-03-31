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
            ResultSet rs = statement.executeQuery("SELECT id, qSecrete, rqSecrete FROM Utilisateur");
            String qSecrete = null;
            String rqSecrete = null;
            while(rs.next()) {
	            System.out.println(rs.getString("id"));
	            if(rs.getString("id").contentEquals(request.getParameter("login"))) {
	      	  		test = true;
	      	  		qSecrete = rs.getString("qSecrete");
	      	  		rqSecrete = rs.getString("rqSecrete");
	      	  	}
            }
            System.out.println("test : "+ test);
            if(test) {
            	/*Envoie du login, de la question secrète et de la réponse secrète via la session pour la page de la question secrète*/
            	request.getSession().setAttribute("login", request.getParameter("login"));
            	request.getSession().setAttribute("qSecrete", qSecrete);
            	request.getSession().setAttribute("rqSecrete", rqSecrete);
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
	

	
}
