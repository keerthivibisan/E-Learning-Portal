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

import databaseConnect.StudentCourseRegister;

@WebServlet("/EnrollCourse")
public class EnrollCourse extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		
		HttpSession enroll = req.getSession(false);
		NavbarProfileInfo fetch = (NavbarProfileInfo) enroll.getAttribute("AllInfoObject");
		int StuID = fetch.getRollNo();
		int CourseID = fetch.getCourseUID();
		String CourseName = fetch.getCourseName();
		
		//Registering in Database & Redirecting
		StudentCourseRegister register = new StudentCourseRegister();
		
		//Checking if user already enrolled for this Course
		if(register.AlreadyEnrolled(StuID, CourseID))
		{
			RequestDispatcher rd = req.getRequestDispatcher("CourseRegister.jsp");
			try
			{
				rd.include(req, res);
				out.println("<center><span style='color: red; background: #2A2A2A; position: absolute; padding: 5em; top:50%; left:38%'>Already Enrolled! Please check MyLearnings</span></center>");
			} 
			catch (ServletException | IOException e)
			{
				e.printStackTrace();
			}
		}
		
		//If not enrolled already enrolling now
		else if(register.StudentCourseRegister(StuID, CourseID, CourseName))
		{
			res.sendRedirect("JavaCourseVideo.jsp");
		}
		
		//If any Error Occurs
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("CourseRegister.jsp");
			try {
				rd.include(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
