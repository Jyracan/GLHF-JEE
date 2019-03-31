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

public class StudentCreationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentListDAO studentListDAO = new StudentListDAO();
		RequestDispatcher rd = null;
		
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
		
		StudentListDAO studentListDAO = new StudentListDAO();
		RequestDispatcher rd = null;
		
		String[] studentProperties = {"id","sexe","nom","prenom","dateNaissance","serieBac","anneeBac"
				,"mentionBac","diplome","anneeDiplome","villeDiplome","inscription","courrielPro","courrielPerso"};
		ArrayList<String> updateProperties = new ArrayList<>();
		
		for(int i = 0; i < studentProperties.length; i++) {
			updateProperties.add(request.getParameter(studentProperties[i]));
		}
		
		studentListDAO.addStudent(updateProperties);
		JOptionPane.showMessageDialog(null,"Etudiant créé");
		rd = getServletContext().getRequestDispatcher("/StudentsList.jsp");
		
		try {
			rd.forward(request, response);
			return;
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
