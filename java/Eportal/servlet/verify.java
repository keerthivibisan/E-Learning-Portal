package Eportal.servlet;
import databaseConnect.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/verify")
public class verify extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		//Object for verification class
		LoginVerification obj = new LoginVerification();
		
		String form_email = req.getParameter("email");
		String form_password = req.getParameter("pass");
		
		
		if(obj.LoginVerify(form_email, form_password))
		{
			HttpSession session = req.getSession();
			session.setAttribute("useremail",form_email);
			res.sendRedirect("home.jsp");
			
		}
		
		else {
			PrintWriter out = res.getWriter();
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, res);
			out.println("<span style='color: red; position: absolute; top:58%; right:20%;'>Useremail or Password incorrect</span>");
			
		}
	}

}
