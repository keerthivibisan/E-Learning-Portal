package Eportal.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreateHttpSession")
public class CreateCourseSession extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String cname = req.getParameter("cname");
		HttpSession st = req.getSession();
    	st.setAttribute("Cname", cname);
    	
    	System.out.println("Here we are in the TRACKKKKK -- Created a session for you");
    	res.sendRedirect("CourseRegister.jsp");
	}
}
