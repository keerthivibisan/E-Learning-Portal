package Eportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseConnect.TGoogleRegister;
import databaseConnect.UserChecker;

@WebServlet(name = "TGoogleLogin", urlPatterns = "/TGoogleLogin")
public class TGoogleSignIn extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
	
	//	System.out.println("AJAX Called");
		String Tname = req.getParameter("Name");
		String Temail = req.getParameter("Email");
		
		System.out.println(Tname+" --- "+Temail);
		
		UserChecker check = new UserChecker();
		
		boolean flag = check.TExistingCheck(Temail);
		
		if(flag)
		{
			System.out.println("Found User");
			HttpSession ses = req.getSession();
			ses.setAttribute("Temail", Temail);
			//res.sendRedirect("Thome.jsp");
			
			//Instead of redirecting sending response back to ajax
			res.setContentType("text/html");
			out.print("Y");
		}
		
		else {
			TGoogleRegister register = new TGoogleRegister();
			boolean flag2 = register.TGoogleRegister(Tname, Temail);
			
			if(flag2)
			{
				//System.out.println("User Registered");
				HttpSession ses = req.getSession();
				ses.setAttribute("Temail", Temail);
				//res.sendRedirect("Thome.jsp");
				out.print("Y");
			}
			
		}
		
	}

}
