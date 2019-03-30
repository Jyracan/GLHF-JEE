package sessionManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	public boolean verify(HttpServletRequest request, HttpServletResponse response) {
		User usr = (User) request.getSession().getAttribute("user");
		if (usr == null) {
			try {
				response.sendRedirect("Connexion");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} else if (request.getRequestURI().indexOf("admin") == 1 && usr.getRights() != "admin") {
			try {
				response.sendRedirect("PermissionInsuffisante");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
}
