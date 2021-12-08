package com.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AdminDAO.UserUNBlocker;

@SuppressWarnings("serial")
@WebServlet("/UnBlocker")
public class UnBlockUser extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String UType = req.getParameter("UType");
		int id = Integer.parseInt(req.getParameter("UserID"));
		
		if(UType.equals("student"))
		{
			UserUNBlocker obj = new UserUNBlocker();
			boolean flag = obj.StuUserUNBlock(id);
			
			RequestDispatcher rd = null;
			if(flag)
			{
				rd = req.getRequestDispatcher("ADMINStudents.jsp");
				rd.include(req, res);
				System.out.println("Un-Blocked");
			}
		}
		
		else if(UType.equals("teacher"))
		{
			UserUNBlocker obj = new UserUNBlocker();
			boolean flag = obj.TUserUNBlock(id);
			
			RequestDispatcher rd = null;
			if(flag)
			{
				rd = req.getRequestDispatcher("AdminTeachers.jsp");
				rd.include(req, res);
				System.out.println("Un-Blocked");
			}
		}
	}

}
