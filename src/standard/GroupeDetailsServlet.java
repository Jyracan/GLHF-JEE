package standard;

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

		GroupeListDAO groupeListDAO = new GroupeListDAO();
		request.setAttribute("listGroupe", groupeListDAO.getGroupeList());
		RequestDispatcher rd = null;
		
		Groupe groupe;
		List<Etudiant> listStudent;

		String searchText = request.getParameter("searchText");
		if (searchText != null) {
			groupe = groupeListDAO.getGroupeDetail(searchText);
			listStudent = groupeListDAO.getMember(searchText);
			request.getSession().setAttribute("groupe", groupe);
			request.getSession().setAttribute("listStudent", listStudent);
		} else {
			groupe = (Groupe) request.getSession().getAttribute("groupe");
			listStudent = groupeListDAO.getMember(groupe.getIdGroupe());
		}
		request.setAttribute("fils", groupeListDAO.getGroupeSons(groupe.getIdGroupe()));
		rd = getServletContext().getRequestDispatcher("/standard/GroupeDetail.jsp");
		try {
			if(listStudent==null) {
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
		doGet(request, response);
	}
}
