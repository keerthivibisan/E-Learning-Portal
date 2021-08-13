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

import databaseConnect.UserChecker;

@WebServlet("/VerifyCodeSender")
public class VerifyCodeSender extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String userName = req.getParameter("name");
		String phoneNumber = req.getParameter("phone");
		String email = req.getParameter("email");
		String password = req.getParameter("confirmpassword");
		
		PrintWriter out = res.getWriter();
		
		UserChecker check = new UserChecker();
		if(check.ExistingUserCheck(email))
		{
			RequestDispatcher rd = req.getRequestDispatcher("register.html");
			rd.include(req, res);
			out.println("<span style='color: red; position: absolute; top:90%; right:18%;'>User Already Registered TRY Login</span>");
			
		}
		
		else {
			
		//Getters & Setters Class
		RegistrationInfoCarrier user = new RegistrationInfoCarrier();
		user.setUserName(userName);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		user.setPassword(password);
		
		//Verification number Generator
		SendVerifyMail obj = new SendVerifyMail();
		String code = obj.generateCode();
		
		user.setCode(code);//Updating it in getters and Setters class
		
		//Calling Send Mail
		boolean status = obj.sendEmail(user);
		
		if(status)
		{
			HttpSession session = req.getSession();
			session.setAttribute("allData",user);
			res.sendRedirect("EnterVerifyCode.jsp");
		}
		
	}

}
}
