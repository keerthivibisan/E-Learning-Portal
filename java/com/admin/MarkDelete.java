package com.admin;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AdminDAO.UserDelete;

@WebServlet("/MarkDelete")
public class MarkDelete extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int CourseId = Integer.parseInt(req.getParameter("CourseID"));
		int SId = Integer.parseInt(req.getParameter("SId"));
		
		UserDelete del = new  UserDelete();
		if(del.StuMarkDelete(SId, CourseId))
		{
			res.sendRedirect("AdminTestMarks.jsp");
		}
	}
}
