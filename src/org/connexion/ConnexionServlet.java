package org.connexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnexionServlet extends HttpServlet{
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		//BookService bookService = new BookServiceImpl();
		
		//List<Book> listBooks =  bookService.getAllBooks();
		
		String pageName="/accueil.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
		//request.setAttribute("listBooks", listBooks);
		try{rd.forward(request, response);}
		catch(ServletException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doProcess(req, resp);
	}
}
