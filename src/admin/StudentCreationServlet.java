package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import DataAccessObjects.StudentListDAO;
import sessionManagement.SessionVerifier;

public class StudentCreationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionVerifier.getInstance().verify(request, response)) {
			return;
		}
		
		RequestDispatcher rd = null;
		request.setAttribute("fail", false);
		rd = getServletContext().getRequestDispatcher("/editor/createStudent.jsp");
		try {
				rd.forward(request, response);
			}
		 	catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionVerifier.getInstance().verify(request, response)) {
			return;
		}
		
		StudentListDAO studentListDAO = new StudentListDAO();
		
		String[] studentProperties = {"id","sexe","nom","prenom","dateNaissance","serieBac","anneeBac"
				,"mentionBac","diplome","anneeDiplome","villeDiplome","inscription","courrielPro","courrielPerso"};
		ArrayList<String> updateProperties = new ArrayList<>();
		
		for(int i = 0; i < studentProperties.length; i++) {
			updateProperties.add(request.getParameter(studentProperties[i]));
		}
		
		if(studentListDAO.addStudent(updateProperties) != null) {
			request.setAttribute("fail", true);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/editor/createStudent.jsp");
			rd.forward(request, response);
			return;
		}
		
		try {
			response.sendRedirect("StudentVisualizationServlet");
			return;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
