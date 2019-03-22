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
	
	/*
	public RequestDispatcher verify(HttpServlet servlet, HttpServletRequest request, String direction) {
		Cookie[] cookies = request.getCookies();
        boolean foundCookie = false;
        int i = 0;
        RequestDispatcher rd;

        while(!foundCookie && i < cookies.length) {
        	if (cookies[i].getName().equals("userId")) {
        		//TODO check id when connection to db done
                foundCookie = true;
            }
        	i++;
        }

        if (!foundCookie) {
        	rd = servlet.getServletContext().getRequestDispatcher("/connexion.jsp");
        } else {
        	rd = servlet.getServletContext().getRequestDispatcher(direction);
        }
		
		return rd;
	}
	*/
	public boolean verify(HttpServletRequest request, HttpServletResponse response) {
		return request.getSession().getAttribute("user") == null;
	}
}
