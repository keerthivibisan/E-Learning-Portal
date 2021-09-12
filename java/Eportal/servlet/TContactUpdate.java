package Eportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseConnect.TProfileUpdate;

@WebServlet(name = "TContactUpdate", urlPatterns = "/TContactUpdate")
public class TContactUpdate extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		
		//System.out.println("AJAX called");
		int id = Integer.parseInt(req.getParameter("Tid"));
		String Contact = req.getParameter("num");
		
		//System.out.println(id+"---"+Contact);
		
		TProfileUpdate update = new TProfileUpdate();
		boolean flag = update.UpdateContact(id, Contact);
		
		if(flag)
		{
			res.setContentType("text/html");
			out.print("Y");
		}
	}

}
