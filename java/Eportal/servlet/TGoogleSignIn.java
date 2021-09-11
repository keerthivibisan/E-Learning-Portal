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

import com.admin.GoogleSignINBlock;

import databaseConnect.TGoogleRegister;
import databaseConnect.UserChecker;

@WebServlet(name = "TGoogleLogin", urlPatterns = "/TGoogleLogin")
public class TGoogleSignIn extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
	
	//	System.out.println("AJAX Called");
		String Tname = req.getParameter("Name");
		String Temail = req.getParameter("Email");
		
		System.out.println(Tname+" --- "+Temail);
		
		UserChecker check = new UserChecker();
		
		GoogleSignINBlock block = new GoogleSignINBlock();
		boolean flag = check.TExistingCheck(Temail, block);
		
		if(flag)
		{
			System.out.println("Found User");
			//res.sendRedirect("Thome.jsp");
			
			//Instead of redirecting sending response back to ajax
			String BlockStatus = block.getBlock();
			if(BlockStatus == null)
			{
				HttpSession ses = req.getSession();
				ses.setAttribute("Temail", Temail);
				res.setContentType("text/html");
				out.print("Y");
			}
			
			else {
				System.out.println("inside "+BlockStatus);
				RequestDispatcher rd = req.getRequestDispatcher("Tlogin.html");
				rd.include(req, res);
				out.print("<span style='color: red; background-color: white;'>Contact Admin</span>");
			}
				
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
				res.setContentType("text/html");
				out.print("Y");
			}
			
		}
		
	}

}
