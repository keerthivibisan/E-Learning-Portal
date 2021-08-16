package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AdminDAO.AdminVerify;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String Email = req.getParameter("Email");
		String password = req.getParameter("pass");
		
		AdminVerify verify = new AdminVerify();
		
		boolean flag = verify.AdminLoginVerify(Email, password);
		
		if(flag)
		{
			HttpSession ses = req.getSession();
			ses.setAttribute("AEmail", Email);
			
			res.sendRedirect("ADMINHome.jsp");
		}
		
		else
		{
			PrintWriter out = res.getWriter();
			RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.html");
			rd.include(req, res);
			out.print("<sspan style='color: red; background-color: white; position: absolute; top:90%; right:43%'>Wrong UserEmail or Password</span>");
		}
	}

}
