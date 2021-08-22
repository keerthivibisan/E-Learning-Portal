package Eportal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseConnect.StuProfileUpdate;

@WebServlet("/UpdateContact")
public class STUUpdateUserContact extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String phone = req.getParameter("Contact");
		String Email = req.getParameter("Uemail");
		
		StuProfileUpdate update = new StuProfileUpdate();
		
		boolean flag = update.UpdateContact(Email, phone);
		
		if(flag)
		{
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.include(req, res);
		}
	}
	
}
