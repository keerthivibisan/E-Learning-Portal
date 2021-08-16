package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AdminDAO.UserDelete;

@WebServlet("/StuVideoDumbDelete")
public class StuSeenVideosDELETE extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String VideoId = req.getParameter("VideoId");
		int Sid = Integer.parseInt(req.getParameter("UserID"));
		int Cid = Integer.parseInt(req.getParameter("CourseId"));
		
		UserDelete delete = new  UserDelete();
		
		boolean flag = delete.StuVideoSeenDelete(VideoId, Cid, Sid);
		
		RequestDispatcher rd = null;
		PrintWriter out = res.getWriter();
		
		if(flag)
		{
			rd = req.getRequestDispatcher("AdminStudentCourseVideoSee.jsp");
			rd.include(req, res);
			System.out.println("Deleted");
		}
	}

}
