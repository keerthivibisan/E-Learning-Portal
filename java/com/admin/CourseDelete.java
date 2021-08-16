package com.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AdminDAO.UserDelete;

@WebServlet("/CourseDelete")
public class CourseDelete extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int CourseId = Integer.parseInt(req.getParameter("CourseID"));
		int UploaderId = Integer.parseInt(req.getParameter("UploaderId"));
		String FilePath = req.getParameter("FilePath");
		
		UserDelete delete = new UserDelete();
		
		boolean flag = delete.CourseDelete(CourseId, UploaderId);
		
		RequestDispatcher rd = null;
		PrintWriter out = res.getWriter();
		
		if(flag)
		{
			System.out.println(FilePath);
			//Deleting File from Location
			File fobj = new File(FilePath);
			String allFiles [] = fobj.list();
			
			//Inner Files delete
			for(String x : allFiles)
			{
				String path = FilePath+"\\"+x;
				File innerFiles = new File(path);
				System.out.println(path);
				innerFiles.delete();
			}
			//Atlast Folder delete
			fobj.delete();
			rd = req.getRequestDispatcher("AdminCourses.jsp");
			rd.include(req, res);
			
		}
	}
	
}
