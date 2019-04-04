package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObjects.Groupe;
import DataAccessObjects.Etudiant;
import DataAccessObjects.GroupeListDAO;
import sessionManagement.SessionVerifier;

public class GroupeDetailsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionVerifier.getInstance().verify(request, response)) {
			return;
		}

		GroupeListDAO goupeListDAO = new GroupeListDAO();
		RequestDispatcher rd = null;
		
		Groupe groupe;
		List<Etudiant> listStudent;

		String searchText = request.getParameter("searchText");
		if (searchText != null) {
			groupe = goupeListDAO.getGroupeDetail(searchText);
			listStudent = goupeListDAO.getMember(searchText);
			request.getSession().setAttribute("groupe", groupe);
			request.getSession().setAttribute("listStudent", listStudent);
		} else {
			groupe = (Groupe) request.getSession().getAttribute("groupe");
			listStudent = goupeListDAO.getMember(groupe.getIdGroupe());
		}
		rd = getServletContext().getRequestDispatcher("/admin/GroupeDetail.jsp");
		try {
			if(groupe == null) {
				System.out.println("groupe null");
				rd.forward(request, response);
			} else if(listStudent==null) {
				System.out.println("studentlist null");
				request.setAttribute("GroupeDetail", groupe); 
				rd.forward(request, response);
			} else {
				request.setAttribute("GroupeDetail", groupe); 
				request.setAttribute("listStudent", listStudent);
				rd.forward(request, response);
			}
		} catch (IOException e) {
				e.printStackTrace();
		} catch (ServletException e) {
				e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String ajtEtudiant = request.getParameter("ajtEtudiant");
		String supprEtudiant =  request.getParameter("supprEtudiant");
		String searchText = request.getParameter("idEtudiant");
		String idGroupe = ((Groupe) request.getSession().getAttribute("groupe")).getIdGroupe();
		
		GroupeListDAO gld = new GroupeListDAO();

		
		if(ajtEtudiant != null) {
			gld.ajtEtu(searchText, idGroupe);
			doGet(request, response);
		}
		else if(supprEtudiant != null) {
			gld.supprEtu(searchText, idGroupe);
			doGet(request, response);
		}
		
	}
}
