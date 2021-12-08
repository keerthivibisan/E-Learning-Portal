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

import databaseConnect.RegisterData;
import databaseConnect.UserChecker;


@SuppressWarnings("serial")
@WebServlet("/VerifyCode")
public class CheckCode extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out = res.getWriter();
		
		String EnteredCode = req.getParameter("verificationCode");
		HttpSession session = req.getSession();
		
		RequestDispatcher rd = null;
		
		RegistrationInfoCarrier user = (RegistrationInfoCarrier) session.getAttribute("allData");
		
		if(EnteredCode.equals(user.getCode()))
		{		
			String userName = user.getUserName();
			String phoneNumber = user.getPhoneNumber();
			String email = user.getEmail();
			String password = user.getPassword();
			
			UserChecker check = new UserChecker();
			if(check.ExistingUserCheck(email))
			{
				rd = req.getRequestDispatcher("register.html");
				rd.include(req, res);
				out.println("<span style='color: red'><center>User Already Registered TRY Login</center></span>");
				
			}
			
			else {
				
				//We are going to write in Database
				RegisterData obj = new RegisterData();
				if(obj.RegisterUserData(userName, phoneNumber, email, password))
				{
					res.sendRedirect("login.jsp");
				}
				
				
			}
		}
		
		else
		{
			rd = req.getRequestDispatcher("EnterVerifyCode.jsp");
			rd.include(req,res);
			out.println("<span style='color: red; position: absolute; top:50%; right:25%;'>Incorrect Code</span>");
		}
	}

}
