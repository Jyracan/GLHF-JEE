package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RedirectionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String chercher = request.getParameter("chercher");
		String supprimer =  request.getParameter("supprimer");
		String searchText = request.getParameter("searchText");
		request.setAttribute("searchText", searchText);
		
		if(chercher != null) {
			rd = getServletContext().getRequestDispatcher("/admin/StudentDetails");
			try {
				rd.forward(request, response);
			}
		 	catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
			}
		}
		else if(supprimer != null) {
			rd = getServletContext().getRequestDispatcher("/admin/StudentDeletion");
			try {
				rd.forward(request, response);
			}
		 	catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
	}
			
		}
		
	}

}
