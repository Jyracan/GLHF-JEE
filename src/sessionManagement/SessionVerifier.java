package sessionManagement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public final class SessionVerifier {
	
	private static SessionVerifier INSTANCE = null;
	
	private SessionVerifier() {
		
	}
	
	public static SessionVerifier getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SessionVerifier(); 
        }
        return INSTANCE;
	}
	
	public RequestDispatcher verify(HttpServlet servlet, HttpServletRequest request, String direction) {
		User user = (User) request.getSession(false).getAttribute("user");
		RequestDispatcher rd;
		
		if(user == null) {
			rd = servlet.getServletContext().getRequestDispatcher("/connexion.jsp");
		} else {
			rd = servlet.getServletContext().getRequestDispatcher(direction);
		}
		
		return rd;
	}
}
