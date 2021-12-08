package Eportal.servlet;



import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/TLogout")
public class Tlogout extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		HttpSession session = req.getSession(false);
		session.removeAttribute("Temail");
		session.invalidate();
		
		res.sendRedirect("Tlogin.html");
		
	}

}
