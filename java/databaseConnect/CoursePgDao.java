package databaseConnect;
import java.sql.*;
import java.util.LinkedList;

import Eportal.servlet.CoursePagePojo;
import Eportal.servlet.DataBaseDetails;

public class CoursePgDao extends DataBaseDetails
{
	public void GetAllCourses(CoursePagePojo obj)
	{
		LinkedList <Integer> id = new LinkedList <Integer>();
		LinkedList <String> img = new LinkedList <String>();
		LinkedList <String> Cname = new LinkedList <String>();
		LinkedList <String> desc = new LinkedList <String>();
		LinkedList <String> jsp = new LinkedList <String>();
		LinkedList <String> status = new LinkedList <String>();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			String query = "select * from courses";
			
			Statement st = con.createStatement();
			ResultSet rd = st.executeQuery(query);
			
			while(rd.next())
			{
				int ID = rd.getInt(1);
				String i = rd.getString(9);
				String nm = rd.getString(2);
				String dsc = rd.getString(8);
				String j = rd.getString(7);
				String stat = rd.getString(5);
				
				id.offer(ID);
				img.offer(i);
				Cname.offer(nm);
				desc.offer(dsc);
				jsp.offer(j);
				status.offer(stat);
			}
			
			obj.setId(id);
			obj.setImg(img);
			obj.setCname(Cname);
			obj.setDesc(desc);
			obj.setJsp(jsp);
			obj.setStatus(status);
			System.out.println("Setted ---- ALL");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
