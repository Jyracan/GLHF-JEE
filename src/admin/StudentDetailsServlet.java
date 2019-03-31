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

		StudentListDAO studentListDAO = new StudentListDAO();
		RequestDispatcher rd = null;
			
		String searchText = request.getParameter("searchText");
		Etudiant etudiant = studentListDAO.getStudentDetail(searchText);
		request.getSession().setAttribute("etudiant", etudiant);
		rd = getServletContext().getRequestDispatcher("/editor/StudentDetail.jsp");
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

