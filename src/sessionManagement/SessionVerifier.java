package sessionManagement;

import java.io.IOException;

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
		String uri = request.getRequestURI();
		if (usr == null) {
			try {
				response.sendRedirect("/ProjetJEE/Connexion");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} else if ((uri.indexOf("admin") == 11 && usr.getRights() != "admin") || (uri.indexOf("editor") == 11 && usr.getRights() == "standard")) {
			try {
				response.sendRedirect("/ProjetJEE/PermissionInsuffisante");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
}
