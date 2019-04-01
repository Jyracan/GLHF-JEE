package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import DataAccessObjects.Etudiant;
import DataAccessObjects.StudentListDAO;
import sessionManagement.SessionVerifier;

public class StudentDeletionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		if (SessionVerifier.getInstance().verify(request, response)) {
			return;
		}
		
		StudentListDAO studentListDAO = new StudentListDAO();
	
		String searchText = request.getParameter("searchText");
		Etudiant etudiant = studentListDAO.getStudentDetail(searchText);	
		studentListDAO.deleteSudent(etudiant);
		JOptionPane.showMessageDialog(null,"Etudiant supprimé");
		
		try {
			response.sendRedirect("StudentVisualizationServlet");
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
		
	}

