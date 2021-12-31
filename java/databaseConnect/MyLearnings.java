package databaseConnect;

import java.sql.*;
import java.util.LinkedList;

import Eportal.servlet.CourseCarrierPojo;
import Eportal.servlet.DataBaseDetails;

public class MyLearnings extends DataBaseDetails {

	public boolean displayCourse(int Sno, CourseCarrierPojo obj)
	{
		boolean flag = false;
		
		LinkedList <String> cname = new LinkedList <String> ();
		LinkedList <String> desc = new LinkedList <String> ();
		LinkedList <String> img = new LinkedList <String> ();
		LinkedList <String> jspfile = new LinkedList <String> ();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select courses.Cno,img,courses.Cname, detail,jspfile from sturegistercourse, courses where Sno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Sno);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				String i = rs.getString(2);
				String cnm = rs.getString(3);
				String dsc = rs.getString(4);
				String j = rs.getString(5);
				
				img.offer(i);
				cname.offer(cnm);
				desc.offer(dsc);
				jspfile.offer(j);
				flag = true;
			}
			
			obj.setCname(cname);
			obj.setDesc(desc);
			obj.setImg(img);
			obj.setJspfile(jspfile);
			
			st.close();
			con.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return(flag);
	}
	
	
}
