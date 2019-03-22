package org.connexion;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		User user = new User(request.getParameter("login"), request.getParameter("password"), "12");
		
		request.getSession().setAttribute("user", user);
		/*Cookie ck = new Cookie("userId", user.getId());
		ck.setMaxAge(-1);
		response.addCookie(ck);*/
		
		response.sendRedirect("Menu");
	}
	
}
