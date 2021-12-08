package Eportal.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class logout extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		// DEleting the Session while Logging out
		HttpSession session = req.getSession();
		session.removeAttribute("useremail");
		session.invalidate();
	
		// Redirecting it back into Login page
		res.sendRedirect("login.jsp");
		
	}
}
