package Eportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseConnect.GamifyRegister;

@WebServlet(name="GamifySupport", urlPatterns="/GamifySupport")
public class GamificationSupport extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		System.out.println("Ajax called");
		
		int score = Integer.parseInt(req.getParameter("Score"));
		System.out.println(score);
		
//		HttpSession ses = req.getSession(false);
//		NavbarProfileInfo fetch = (NavbarProfileInfo) ses.getAttribute("UserDetails");
		HttpSession enroll = req.getSession(false);
		NavbarProfileInfo fetch = (NavbarProfileInfo) enroll.getAttribute("GamifySupport");
		
		int rollNo = fetch.getRollNo();
		
		GamifyRegister obj = new GamifyRegister();
		String date = obj.GetDate();
		System.out.println(date);
		
		boolean check = obj.AlreadyAttended(rollNo);
		
		if(check)
		{
			res.setContentType("text/html");
			out.print("AlreadyWritten");
		}
		
		else {
			//Registering Score
			boolean flag = obj.EnterMark(score, rollNo, date);
			
			if(flag)
			{
				res.setContentType("text/html");
				out.print("true...");
				
			}
		}
	}
}
