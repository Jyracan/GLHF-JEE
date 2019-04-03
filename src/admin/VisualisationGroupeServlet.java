package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObjects.Groupe;
import DataAccessObjects.GroupeListDAO;
import sessionManagement.SessionVerifier;

public class VisualisationGroupeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess( request,  response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess( request,  response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (SessionVerifier.getInstance().verify(request, response)) {
			return;
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/visualisationGroupe.jsp");
		
		// OBTENTION DES GROUPES
			
		GroupeListDAO groupeListDAO = new GroupeListDAO();
		List<Groupe> listGroupes = groupeListDAO.getGroupeList();
		
		try {
			request.setAttribute("listGroupe", listGroupes);
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
