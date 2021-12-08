package Eportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseConnect.StudentVideoRegister;

@SuppressWarnings("serial")
@WebServlet(name = "CheckAlreadySeen", urlPatterns = "/CheckAlreadySeen")
public class AlreadySeenVideoCheck extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
//		System.out.println("Ajax Called");
		PrintWriter out = res.getWriter();
		
		String VideoId = req.getParameter("VideoId");
		
		HttpSession enroll = req.getSession(false);
		NavbarProfileInfo fetch = (NavbarProfileInfo) enroll.getAttribute("UserDetails");
		//Student Details
		int Sid = fetch.getRollNo();
		
		StudentVideoRegister seen = new StudentVideoRegister();
		
		boolean flag = seen.AlreadySaw(Sid, VideoId);
		
		if(flag)
		{
			res.setContentType("text/html");
			out.print("true");
		}
		
		else {
			res.setContentType("text/html");
			out.print("false");
		}
	}

}
