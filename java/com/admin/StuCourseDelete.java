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

@SuppressWarnings("serial")
@WebServlet("/StuCourseDelete")
public class StuCourseDelete extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int CourseId = Integer.parseInt(req.getParameter("CourseId"));
		int Sid = Integer.parseInt(req.getParameter("UserID"));
		
		UserDelete delete = new UserDelete();
		
		boolean flag = delete.StuRegisterCourseDelete(CourseId, Sid);
		
		RequestDispatcher rd = null;
		@SuppressWarnings("unused")
		PrintWriter out = res.getWriter();
		
		if(flag)
		{
			rd = req.getRequestDispatcher("AdminStuCourseRegister.jsp");
			rd.include(req, res);
			System.out.println("Deleted");
		}
	}
	
}
