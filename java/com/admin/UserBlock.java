package com.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AdminDAO.UserBlocker;

@WebServlet("/BlockUser")
public class UserBlock extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String UType = req.getParameter("UType");
		int id = Integer.parseInt(req.getParameter("UserID"));
		
		if(UType.equals("student"))
		{
			UserBlocker obj = new UserBlocker();
			boolean flag = obj.StuUserBlock(id);
			
			RequestDispatcher rd = null;
			if(flag)
			{
				rd = req.getRequestDispatcher("ADMINStudents.jsp");
				rd.include(req, res);
				System.out.println("Blocked");
			}
			
		}
		
		else if(UType.equals("teacher"))
		{
			UserBlocker obj = new UserBlocker();
			boolean flag = obj.TUserBlock(id);
			
			RequestDispatcher rd = null;
			if(flag)
			{
				rd = req.getRequestDispatcher("AdminTeachers.jsp");
				rd.include(req, res);
				System.out.println("Blocked");
			}
			
		}
	}

}
