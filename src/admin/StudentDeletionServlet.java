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

public class StudentDeletionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		StudentListDAO studentListDAO = new StudentListDAO();
		RequestDispatcher rd = null;
		String searchText = request.getParameter("searchText");
		Etudiant etudiant = studentListDAO.getStudentDetail(searchText);	
		studentListDAO.deleteSudent(etudiant);
		JOptionPane.showMessageDialog(null,"Etudiant supprimé");
		rd = getServletContext().getRequestDispatcher("/editor/StudentsList.jsp");
		try {
			rd.forward(request, response);
		}catch(ServletException | IOException e) {
			e.printStackTrace();
		}	
	}
		
	}

