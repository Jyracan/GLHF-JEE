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

import DataAccessObjects.Etudiant;
import DataAccessObjects.StudentListDAO;
import sessionManagement.SessionVerifier;


public class StudentModificationServlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionVerifier.getInstance().verify(request, response)) {
			return;
		}
		
		StudentListDAO studentListDAO = new StudentListDAO();
		RequestDispatcher rd = null;
		Etudiant etudiant = (Etudiant) request.getSession().getAttribute("etudiant");
		rd = getServletContext().getRequestDispatcher("/admin/StudentModification.jsp");
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionVerifier.getInstance().verify(request, response)) {
			return;
		}
		
		StudentListDAO studentListDAO = new StudentListDAO();
		RequestDispatcher rd = null;
		
		String[] studentProperties = {"sexe","nom","prenom","dateNaissance","serieBac","anneeBac"
				,"mentionBac","diplome","anneeDiplome","villeDiplome","inscription","courrielPro","courrielPerso"};
		ArrayList<String> updateProperties = new ArrayList<>();
		
		Etudiant etudiant = (Etudiant) request.getSession().getAttribute("etudiant");
		String id = etudiant.getId();
		updateProperties.add(id);
		
		for(int i = 1; i <= studentProperties.length; i++) {
			updateProperties.add(request.getParameter(studentProperties[i-1]));
		}
		
		studentListDAO.updateStudent(updateProperties);
		JOptionPane.showMessageDialog(null,"Etudiant modifié");
		rd = getServletContext().getRequestDispatcher("/editor/StudentsList.jsp");
		
		try {
			rd.forward(request, response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}


}
