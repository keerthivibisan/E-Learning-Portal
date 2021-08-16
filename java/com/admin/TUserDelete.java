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

@WebServlet("/TUserDelete")
public class TUserDelete extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		int UID = Integer.parseInt(req.getParameter("UserID"));
		String Email = req.getParameter("UEmail");
		
		UserDelete delete = new UserDelete();
		
		boolean flag = delete.TUserDelete(Email, UID);
		
		RequestDispatcher rd = null;
		PrintWriter out = res.getWriter();
		
		if(flag)
		{
			rd = req.getRequestDispatcher("AdminTeachers.jsp");
			rd.include(req, res);
			System.out.println("Deleted");
		}
	}
}
	

