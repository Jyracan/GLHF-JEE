package standard;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObjects.DBManagerAuth;
import sessionManagement.SessionVerifier;
import sessionManagement.User;

public class ProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionVerifier.getInstance().verify(request, response)) {
			return;
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/standard/profile.jsp");
		request.setAttribute("user", request.getSession().getAttribute("user"));
		try {
			rd.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = DBManagerAuth.getInstance().getConnection();
		User usr = (User) request.getSession().getAttribute("user");
		String newPsw = request.getParameter("password");
		String newQ = request.getParameter("question");
		String newA = request.getParameter("answer");
		try {
			if(!(newPsw.contentEquals("") || newQ.contentEquals("") || newA.contentEquals(""))) {
				PreparedStatement pstmt = connection.prepareStatement("UPDATE Utilisateur SET mdp = ?, qSecrete = ?, rqSecrete = ? WHERE id = ?");
				pstmt.setString(1, request.getParameter("password"));
				pstmt.setString(2, request.getParameter("question"));
				pstmt.setString(3, request.getParameter("answer"));
				pstmt.setString(4, usr.getLogin());
				pstmt.executeUpdate();
				usr.setPassword(newPsw);
				usr.setQuestion(newQ);
				usr.setAnswer(newA);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request,response);
	}
}
