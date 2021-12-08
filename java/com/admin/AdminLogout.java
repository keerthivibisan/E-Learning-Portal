package com.admin;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		HttpSession ses = req.getSession(false);
		ses.removeAttribute("AEmail");
		ses.invalidate();
		
		res.sendRedirect("AdminLogin.html");
	}

}
