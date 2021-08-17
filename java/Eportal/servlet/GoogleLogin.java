package Eportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseConnect.RegisterData;
import databaseConnect.UserChecker;

@WebServlet(name = "GoogleLogin", urlPatterns = "/GoogleLogin")
public class GoogleLogin extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		System.out.println("Ajax Called");
		PrintWriter out = res.getWriter();
		
		String email = req.getParameter("Email");
		String name = req.getParameter("Name");
		String phone = null;
		String pass = "Google-User";
		//System.out.println(email);
		//System.out.println(name);
		
		//Checking Already USER Registered in our database
		UserChecker check = new UserChecker();
		boolean flag = check.ExistingUserCheck(email);
		
		if(flag)
		{
			HttpSession session = req.getSession();
			session.setAttribute("useremail",email);
			//res.sendRedirect("home.jsp");
			//System.out.println("Existing user, Session set");
			res.setContentType("text/html");
			out.print("true");
		}
		
		else
		{
			RegisterData register = new RegisterData();
			boolean f = register.RegisterUserData(name, phone, email, pass);
			
			if(f)
			{
				System.out.println("Registered");
				HttpSession session = req.getSession();
				session.setAttribute("useremail",email);
				//res.sendRedirect("home.jsp");
				res.setContentType("text/html");
				out.print("true");
			}
		}
	}

}
