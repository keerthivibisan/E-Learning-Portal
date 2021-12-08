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

import databaseConnect.TExistingModuleCheckDAO;

@SuppressWarnings("serial")
@WebServlet("/ExistingModuleCheck")
public class TExistingModuleUpload extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
		
		int TUid = Integer.parseInt(req.getParameter("Tuid"));
		int Cid = Integer.parseInt(req.getParameter("Cid"));
		
		//Pojo
		FileUploadInfoCarrier carry = new FileUploadInfoCarrier();
		carry.setCid(Cid);
		carry.setUID(TUid);
		
		TExistingModuleCheckDAO check = new TExistingModuleCheckDAO();
		
		if(check.CheckExistingCourse(carry))
		{
			HttpSession ExistingUpdate = req.getSession();
			ExistingUpdate.setAttribute("ExistingUploadOBJ", carry);
			res.sendRedirect("TUpdateGetter.jsp");
		}
		
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("TExistingUpdate.jsp");
			rd.include(req, res);
			out.println("<span style='color: red; background-color: white; position: absolute; top:64%; right:30%'>Sorry! No such Course ID Exist with Your ID</span>");
		}
	}
}
