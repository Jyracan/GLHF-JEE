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
		Connection connection = DBManagerAuth.getInstance().getConnection();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/questionSecrete.jsp");
		try {
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reponseSecrete = (String) request.getParameter("rqSecrete");
		String rqSecrete = (String) request.getSession().getAttribute("rqSecrete");
		if(reponseSecrete.contentEquals(rqSecrete)) {
			response.sendRedirect("QuestionSecrete");
		}else {
			response.sendRedirect("Connexion");
		}
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