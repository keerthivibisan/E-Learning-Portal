package databaseConnect;

import java.sql.*;
import java.util.LinkedList;

import Eportal.servlet.DataBaseDetails;
import Eportal.servlet.TmyUploadsCarrier;
public class TStudentGetterDAO extends DataBaseDetails{
	
	LinkedList <Integer> SId = new LinkedList <Integer> ();
	LinkedList <String> Sname = new LinkedList <String> ();
	LinkedList <String> Semail = new LinkedList <String> ();
	LinkedList <String> Scontact = new LinkedList <String> ();
	
	public boolean CourseStudentGet(int Cid, TmyUploadsCarrier obj)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from studentdetails, sturegistercourse where studentdetails.Sno=sturegistercourse.Sno and sturegistercourse.Cno= ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Cid);
			
			ResultSet rd = st.executeQuery();
			
			while(rd.next())
			{
				int Stuid = rd.getInt(5);
				String stuname = rd.getString(1);
				String stuemail = rd.getString(4);
				String stunumber = rd.getString(3);
				
				//Adding to list
				SId.offer(Stuid);
				Sname.offer(stuname);
				Semail.offer(stuemail);
				Scontact.offer(stunumber);
				
				flag = true;
			}
			
			//Setting up tp POJO
			obj.setSId(SId);
			obj.setSname(Sname);
			obj.setSemail(Semail);
			obj.setScontact(Scontact);
			
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
