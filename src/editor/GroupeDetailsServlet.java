package editor;

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
import sessionManagement.User;

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
		rd = getServletContext().getRequestDispatcher("/admin/GroupeDetail.jsp");
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
		
		String ajtEtudiant = request.getParameter("ajtEtudiant");
		String supprEtudiant =  request.getParameter("supprEtudiant");
		String searchText = request.getParameter("idEtudiant");
		String idGroupe = ((Groupe) request.getSession().getAttribute("groupe")).getIdGroupe();
		String ajtGroupe = request.getParameter("ajtGroupe");
		String supprGroupe =  request.getParameter("supprGroupe");
		String searchGroupe = request.getParameter("idGroupe");
		
		GroupeListDAO gld = new GroupeListDAO();
		
		User user = (User) request.getSession().getAttribute("user");
		String editor = user.getLogin();
		if(user.getRights().contentEquals("admin")) {
			editor = "";
		}
		
		if(ajtEtudiant != null && searchText != "") {
			gld.ajtEtu(searchText, idGroupe, editor);
			doGet(request, response);
		} else if(supprEtudiant != null && searchText != "") {
			gld.supprEtu(searchText, idGroupe, editor);
			doGet(request, response);
		} else if(ajtGroupe != null && searchGroupe != "") {
			gld.addGrpToGrp(idGroupe, searchGroupe, editor);
			doGet(request, response);
		} else if(supprGroupe != null && searchGroupe != "") {
			gld.delGrpToGrp(idGroupe, searchGroupe, editor);
			doGet(request, response);
		}
		
	}
}
