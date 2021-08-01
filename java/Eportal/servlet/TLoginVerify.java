package Eportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseConnect.LoginVerification;

@WebServlet("/TLoginVerify")
public class TLoginVerify extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
		
		String Temail = req.getParameter("Temail");
		String Tpass = req.getParameter("Tpass");
		
		LoginVerification verify = new LoginVerification();
		
		if(verify.TLoginVerify(Temail, Tpass))
		{
			HttpSession session = req.getSession();
			session.setAttribute("Temail", Temail);
			res.sendRedirect("Thome.jsp");
		}
		
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("Tlogin.html");
			rd.include(req, res);
			out.print("<span style='color: red; background-color: white; position: absolute; top:55%; right:27%'>Wrong UserEmail or Password</span>");
		}
	}

}
