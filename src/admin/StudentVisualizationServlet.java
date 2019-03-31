package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObjects.Etudiant;
import DataAccessObjects.StudentListDAO;
import sessionManagement.SessionVerifier;

public class StudentVisualizationServlet extends HttpServlet {
       
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
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/editor/StudentsList.jsp");
		
		StudentListDAO studentListDAO = new StudentListDAO();
		List<Etudiant> listStudents = studentListDAO.getStudentList();
		try {
			request.setAttribute("listStudent", listStudents);
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
