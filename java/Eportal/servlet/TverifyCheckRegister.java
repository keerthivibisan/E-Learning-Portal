package Eportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseConnect.TregistrationDAO;


@SuppressWarnings("serial")
@WebServlet("/TVerifyCheck")
public class TverifyCheckRegister extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String Tcode = req.getParameter("Vcode");
		
		HttpSession session = req.getSession(false);
		TregistrationInfoCarrier obj = (TregistrationInfoCarrier) session.getAttribute("Tobject");
		String code = obj.getCode();
		
		PrintWriter out = res.getWriter();
		
		if(Tcode.equals(code))
		{
			//Registering in Database
			TregistrationDAO register = new TregistrationDAO();
			
			//Passing POJO Class object
			boolean flag = register.RegisterTeacher(obj);
			
			if(flag)
			{
				res.sendRedirect("Tlogin.html");
			}
			
		}
		
		else {
			RequestDispatcher rd = req.getRequestDispatcher("Tverify.html");
			rd.include(req, res);
			out.println("<span style='color: red; background-color: white; position: absolute; top:55%; right:25%'>Wrong Verification Code</span>");
		}
	}

}
