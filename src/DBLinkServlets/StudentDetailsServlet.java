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

@WebServlet("/StudentDetailsServlet")
public class StudentDetailsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess (HttpServletRequest request, HttpServletResponse response) {
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/StudentDetail.jsp");
		String searchText = request.getParameter("searchText");
		StudentListDAO studentListDAO = new StudentListDAO();
		Etudiant etudiant = studentListDAO.getStudentDetail(searchText);
		try {
			if(etudiant == null)
			{
				rd = getServletContext().getRequestDispatcher("/StudentsList.jsp");
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
