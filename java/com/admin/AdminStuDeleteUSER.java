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


@WebServlet("/StuUserDelete")
public class AdminStuDeleteUSER extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int UID = Integer.parseInt(req.getParameter("UserID"));
		String Email = req.getParameter("UEmail");
		
		// System.out.println(UID);
		// System.out.println(Email);
		
		UserDelete delete = new UserDelete();
		
		boolean flag = delete.deleteStudent(Email, UID);
		
		RequestDispatcher rd = null;
		PrintWriter out = res.getWriter();
		
		if(flag)
		{
			rd = req.getRequestDispatcher("ADMINStudents.jsp");
			rd.include(req, res);
			System.out.println("Deleted");
		}
	}

}
