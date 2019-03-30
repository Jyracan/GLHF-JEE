package DBLinkServlets;

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
		String buttonPressed3 = request.getParameter("sauvegarderModifications");
		StudentListDAO studentListDAO = new StudentListDAO();
		RequestDispatcher rd = null;
		
		if(buttonPressed2!=null) {
			
			String searchText = request.getParameter("searchText");
			Etudiant etudiant = studentListDAO.getStudentDetail(searchText);
			rd = getServletContext().getRequestDispatcher("/StudentModification.jsp");
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
	
		else if(buttonPressed3!=null) {
			
			String[] studentProperties = {"studentModified","sexe","nom","prenom","dateNaissance","serieBac","anneeBac"
					,"mentionBac","diplome","anneeDiplome","villeDiplome","inscription","courrielPro","courrielPerso"};
			ArrayList<String> updateProperties = new ArrayList<>();
			
			for(int i = 0; i < studentProperties.length; i++) {
				updateProperties.add(request.getParameter(studentProperties[i]));
			}
			
			studentListDAO.updateStudent(updateProperties);
			JOptionPane.showMessageDialog(null,"Etudiant modifié");
			Etudiant etudiant = studentListDAO.getStudentDetail(updateProperties.get(2)+" "+updateProperties.get(3));
			rd = getServletContext().getRequestDispatcher("/StudentModification.jsp");
			
			try {
				request.setAttribute("StudentDetail", etudiant);
				rd.forward(request, response);
				
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		else
		{
			String searchText = request.getParameter("searchText");
			Etudiant etudiant = studentListDAO.getStudentDetail(searchText);	
			rd = getServletContext().getRequestDispatcher("/StudentDetail.jsp");
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
}
