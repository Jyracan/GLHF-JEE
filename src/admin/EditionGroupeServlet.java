package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObjects.DBManager;
import DataAccessObjects.Etudiant;
import DataAccessObjects.Groupe;
import DataAccessObjects.GroupeListDAO;
import DataAccessObjects.StudentListDAO;
import sessionManagement.SessionVerifier;

public class EditionGroupeServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			/*
			String groupName = request.getParameter("groupName");
			System.out.println(groupName);
			Connection connection = DBManager.getInstance().getConnection();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/gestionGroupe.jsp");
			try {
	        Statement statementGroupe = connection.createStatement();
	        ResultSet rs = statementGroupe.executeQuery("SELECT nomGroupe FROM Groupe");
	        while(rs.next())
	        {
	         // Si le nom du groupe existe déjà, on l'insère pas dans la bdd
	      	  if(rs.getString("nomGroupe").contentEquals(groupName)) {
	      		RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/admin/creationGroupe.jsp");
	    		
	    		try {
	    			rd2.forward(request, response);
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		} catch (ServletException e) {
	    			e.printStackTrace();
	    		}
	      	  }
	         }
			}
			catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
			
	        try {
	        	Statement statement = connection.createStatement();
	        	String id = (String) request.getSession().getAttribute("login");
	        	String query = "insert into Groupe(nomGroupe, redacteur) values (" + "\""+groupName +"\""+ ",\""+ id+"\");";
	        	System.out.println(query);
	        	int rs2 = statement.executeUpdate(query);
	        	
	        }
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        */
		}

	}