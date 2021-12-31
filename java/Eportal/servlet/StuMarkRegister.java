package Eportal.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseConnect.StuMarkRegisterDAO;

@WebServlet(name = "StuMarkRegister", urlPatterns="/StuMarkRegister")
public class StuMarkRegister extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		HttpSession mark = req.getSession(false);
		NavbarProfileInfo obj = (NavbarProfileInfo) mark.getAttribute("StuObj");
		
		int Sno = obj.getRollNo();
		int Cno = (int) mark.getAttribute("Cid");
		int m = Integer.parseInt(req.getParameter("mark"));
		
		GamifyJSPScoreCarrier carry = new GamifyJSPScoreCarrier();
		carry.setCno(Cno);
		carry.setScore(m);
		carry.setSno(Sno);
		
		StuMarkRegisterDAO register = new StuMarkRegisterDAO();
		register.RegisterMark(carry);
	}

}
