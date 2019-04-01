package admin;

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

import DataAccessObjects.DBManager;
import sessionManagement.SessionVerifier;

public class SuppressionGroupeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionVerifier.getInstance().verify(request, response)) {
			return;
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/suppressionGroupe.jsp");
		
		try {
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String groupName = request.getParameter("groupName");
		Connection connection = DBManager.getInstance().getConnection();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/gestionGroupe.jsp");
		boolean test = false;
		String id_group = null;
		try {
        Statement statementGroupe = connection.createStatement();
        ResultSet rs = statementGroupe.executeQuery("SELECT idGroupe, nomGroupe FROM Groupe");
        while(rs.next())
        {
         // Si le nom du groupe n'est pas dans la bdd, on ne le supprime pas
        	if(rs.getString("nomGroupe").contentEquals(groupName)) {
        		test = true;
        	}
         }
        if(!test) {
      		RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/admin/gestionGroupe.jsp");
    		
    		try {
    			rd2.forward(request, response);
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (ServletException e) {
    			e.printStackTrace();
    		}
      	  }
        else {
	        Statement statementGroupe2 = connection.createStatement();
	        ResultSet rs3 = statementGroupe.executeQuery("SELECT idGroupe FROM Groupe where nomGroupe =\""+groupName +"\";");
	        id_group=rs3.getString("idGroupe");
        }
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
		
		
		try {
			if(!groupName.isEmpty() && !test) {
	        	Statement statement = connection.createStatement();
	        	String id = (String) request.getSession().getAttribute("login");
	        	String query = "delete from Groupe where nomGroupe = \"" + groupName +"\";";
	        	String queryStudent = " delete from Etudiant_has_Groupe where Groupe_idGroupe =\""+id_group+"\";";
	        	String queryGroup = " delete from Groupe_has_Groupe where idGroupeAscendant =\""+id_group+"\" or idGroupeDescendant =\""+id_group+"\";";
	        	System.out.println(query);
	        	System.out.println(queryStudent);
	        	System.out.println(queryGroup);
	        	int rs2 = statement.executeUpdate(query);
	        	int rs3 = statement.executeUpdate(queryStudent);
	        	int rs4 = statement.executeUpdate(queryGroup);
			}
        	
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
		
		
		//Redirection
        
        RequestDispatcher rdd = getServletContext().getRequestDispatcher("/admin/gestionGroupe.jsp");
		
		try {
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
}
