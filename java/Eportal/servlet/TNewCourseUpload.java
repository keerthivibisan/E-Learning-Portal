package Eportal.servlet;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/TNewCourseUpload")
public class TNewCourseUpload extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		System.out.println("In SERVLET");
		RequestDispatcher rd = null;
		
		try 
		{
			PrintWriter out = res.getWriter();
			System.out.println("ABOVE INPUTS");
			int UID = Integer.parseInt(req.getParameter("UID"));
			String Cname = req.getParameter("Cname");
//			System.out.println(UID);
//			System.out.println(Cname);
			String Fpath = "D:\\JAVA-EE-workspace\\E-Portal\\src\\main\\webapp\\Courses\\"+Cname+"("+UID+")";
			
			File fobj = new File("D:\\JAVA-EE-workspace\\E-Portal\\src\\main\\webapp\\Courses\\"+Cname+"("+UID+")");
			
			boolean isExist = fobj.exists();
			
			if(isExist)
			{
				rd=req.getRequestDispatcher("TnewFileUpload.jsp");
				rd.include(req, res);
				out.println("<span style='color: red; background-color: white; position: absolute; top:70%; right:30%'>Sorry! Course Name already Exist</span>");
			}
			
			else
			{
				fobj.mkdir();
				FileUploadInfoCarrier carry = new FileUploadInfoCarrier();
				carry.setUID(UID);
				carry.setCname(Cname);
				carry.setFpath(Fpath);
				HttpSession uploadSes = req.getSession();
				uploadSes.setAttribute("UploaderObj", carry);
				rd = req.getRequestDispatcher("TVideoInput.jsp");
				rd.forward(req, res);
			}
				
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
