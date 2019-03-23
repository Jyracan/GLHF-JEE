package DBLinkServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObjects.Etudiant;
import DataAccessObjects.StudentListDAO;
import sessionManagement.SessionVerifier;

@WebServlet("/StudentDetailsServlet")
public class StudentDetailsServlet extends HttpServlet {
	
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

		String buttonPressed1 = request.getParameter("chercher"); //pour savoir sur quel bouton on a cliqué
		String buttonPressed2 = request.getParameter("modifier");
		RequestDispatcher rd = null;
		if(buttonPressed1!=null) {
			rd = getServletContext().getRequestDispatcher("/StudentDetail.jsp");
		}
		if(buttonPressed2!=null) {
			rd = getServletContext().getRequestDispatcher("/StudentModification.jsp");
		}
		String searchText = request.getParameter("searchText");
		StudentListDAO studentListDAO = new StudentListDAO();
		Etudiant etudiant = studentListDAO.getStudentDetail(searchText);
		try {
			if(etudiant == null)
			{
				rd.forward(request, response);
			}
			else 
			{
				request.setAttribute("StudentDetail", etudiant);
				rd.forward(request, response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
