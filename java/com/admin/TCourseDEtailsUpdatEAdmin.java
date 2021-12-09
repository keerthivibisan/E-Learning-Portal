package com.admin;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Eportal.servlet.FileUploadInfoCarrier;
import databaseConnect.TeacherCourseEdit;

@WebServlet("/TCourseDEtailsUpdatEAdmin")
public class TCourseDEtailsUpdatEAdmin extends HttpServlet
{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int id = Integer.parseInt(req.getParameter("cid"));
		String img = req.getParameter("imgurl");
		String name = req.getParameter("cname");
		String desc = req.getParameter("desc");
		int Uid = Integer.parseInt(req.getParameter("uid"));
		String status = req.getParameter("status");
		
		FileUploadInfoCarrier carry = new FileUploadInfoCarrier();
		carry.setCid(id);
		carry.setCname(name);
		carry.setDesc(desc);
		carry.setImgurl(img);
		carry.setUID(Uid);
		carry.setStatus(status);
		
		//System.out.println(desc);
		
		TeacherCourseEdit update = new TeacherCourseEdit();
		if(update.UpdateCourseDetailsAdmin(carry))
		{
			res.sendRedirect("AdminCourseView.jsp");
		}
		
	}
	
}
