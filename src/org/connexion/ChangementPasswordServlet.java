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

public class ChangementPasswordServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/changementPassword.jsp");
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/changementPassword.jsp");
		RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/connexion.jsp");
		String password = request.getParameter("psw");
		String passwordConfirmation = request.getParameter("pswConfirmation");
		/*Si les deux mots de passe concordent, alors on modifie le mot de passe dans la bdd*/
		if(password.contentEquals(passwordConfirmation)) {
			try {
	            Statement statement = connection.createStatement();
	            String id = (String) request.getSession().getAttribute("login");
	            System.out.println(id);
	            String query = "update Utilisateur set mdp=\"" + password +"\" where id=\"" + id+"\"";
	            System.out.println(query);
				int rs = statement.executeUpdate(query);
			}
			catch (SQLException e) 
	         {
	             e.printStackTrace();
	         }
		}
		try {
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
