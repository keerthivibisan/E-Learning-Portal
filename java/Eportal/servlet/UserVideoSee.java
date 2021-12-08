package Eportal.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseConnect.CourseInfoFetch;
import databaseConnect.StudentVideoRegister;

@SuppressWarnings("serial")
@WebServlet(name="UserVideoRegister", urlPatterns="/UserVideoRegister")
public class UserVideoSee extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		System.out.println("AJAX Called");
		
		PrintWriter out = res.getWriter();
		
		String VideoId = req.getParameter("VideoId");
		
		System.out.println(VideoId);
		
		//Getting User Details
		HttpSession ses = req.getSession(false);
		NavbarProfileInfo fetch = (NavbarProfileInfo) ses.getAttribute("UserDetails");
		//Student Details
		int Sid = fetch.getRollNo();
		
		//Course name 
		String Cname = ses.getAttribute("CourseName").toString();
		//Fetching Course id using Course Name
		NavbarProfileInfo doget = new NavbarProfileInfo();
		
		CourseInfoFetch get = new CourseInfoFetch();
		get.CourseDetails(Cname, doget);
		
		int Cid = doget.getCourseUID();
		//Success System.out.println(Cid);
		
		
		//Video Registering on see--------
		StudentVideoRegister obj = new StudentVideoRegister();
		
		String Date = obj.getDate();
		System.out.println(Date);
		
		//AlreadySeen Video CASE
		boolean flag = obj.AlreadySaw(Sid, VideoId);
		
		if(flag)
		{
			System.out.println(flag);
			System.out.println("Already saw");
		}
		
		//If not already seen now register in DB
		else
		{
			boolean flag2 = obj.VideoSeenNow(VideoId, Sid, Cid, Date);
			
			if(flag2)
			{
				res.setContentType("text/html");
				System.out.println("Added to Database");
				out.print("true");
				
			}
		}
		
	}
	
}
