package Eportal.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Tregistration")
public class Tregistration extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String Tname = req.getParameter("Tname");
		String Temail = req.getParameter("Temail");
		String Tcontact = req.getParameter("Tcontact");
		String Tpassword = req.getParameter("Cpass");
		
		TregistrationInfoCarrier Tuser = new TregistrationInfoCarrier();
		
		Tuser.setTname(Tname);
		Tuser.setTemail(Temail);
		Tuser.setTcontact(Tcontact);
		Tuser.setTpass(Tpassword);
		
		TverifyMailSender obj = new TverifyMailSender();
		
		//Generating Random Number
		String code = obj.GenerateVCode();
		
		Tuser.setCode(code);
		
		//Now Sending Email
		boolean flag = obj.SendEmail(Tuser);
		
		if(flag)
		{
			HttpSession session = req.getSession();
			session.setAttribute("Tobject", Tuser);
			res.sendRedirect("Tverify.html");
		}
	}

}
