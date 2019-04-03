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
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess (HttpServletRequest request, HttpServletResponse response) {
		if (SessionVerifier.getInstance().verify(request, response)) {
			return;
		}

		GroupeListDAO goupeListDAO = new GroupeListDAO();
		RequestDispatcher rd = null;
		

		String searchText = request.getParameter("searchText");
		Groupe groupe = goupeListDAO.getGroupeDetail(searchText);
		List<Etudiant> listStudent = goupeListDAO.getMember(searchText);
		request.getSession().setAttribute("groupe", groupe);
		request.getSession().setAttribute("listStudent", listStudent);
		rd = getServletContext().getRequestDispatcher("/admin/GroupeDetail.jsp");
		try {
			if(groupe == null)
			{
					rd.forward(request, response);
			}
			else
			{
					request.setAttribute("GroupeDetail", groupe); //TODO : Faire l'équivalent pour étudiant !
					request.setAttribute("listStudent", listStudent);
					rd.forward(request, response);
			}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		}	

