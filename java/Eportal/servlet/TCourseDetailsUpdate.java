package Eportal.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseConnect.TeacherCourseEdit;

@WebServlet("/TCourseDEtailsUpdate")
public class TCourseDetailsUpdate extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int id = Integer.parseInt(req.getParameter("cid"));
		String img = req.getParameter("imgurl");
		String name = req.getParameter("cname");
		String desc = req.getParameter("desc");
		
		FileUploadInfoCarrier carry = new FileUploadInfoCarrier();
		carry.setCid(id);
		carry.setCname(name);
		carry.setDesc(desc);
		carry.setImgurl(img);
		//System.out.println(desc);
		
		TeacherCourseEdit update = new TeacherCourseEdit();
		if(update.UpdateCourseDetails(carry))
		{
			res.sendRedirect("TmyCourses.jsp");
		}
		
	}

}
