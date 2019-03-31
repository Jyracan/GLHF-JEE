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

public class QuestionSecreteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = (String) request.getSession().getAttribute("login");
		Connection connection = DBManagerAuth.getInstance().getConnection();
		try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, qSecrete, rqSecrete FROM Utilisateur");
            String qSecrete = null;
            String rqSecrete = null;
            while(rs.next()) {
	            System.out.println(rs.getString("id"));
	            if(rs.getString("id").contentEquals(login)) {
	      	  		qSecrete = rs.getString("qSecrete");
	      	  		rqSecrete = rs.getString("rqSecrete");
	      	  	}
            }
            /*if(test) {
            	request.getSession().setAttribute("login", request.getParameter("login"));
            	response.sendRedirect("QuestionSecrete");            
            }
            else {
            	response.sendRedirect("Connexion");
            }*/ 
         } 
         catch (SQLException e) 
         {
             e.printStackTrace();
         }
		login = null;
		//Une fois login utilisé, le mettre à null pour laver la session
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	private void doProcess (HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/questionSecrete.jsp");
		try {
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}