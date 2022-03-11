package databaseConnect;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;
import Eportal.servlet.NavbarProfileInfo;


public class CourseInfoFetch extends DataBaseDetails {
	
	
	public boolean CourseDetails(String cname, NavbarProfileInfo obj)
	{
		boolean flag = false;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			String query = "select Cno,Tname,Temail from courses,teacher where courses.UploaderTno=teacher.Tno and Cname = ?"; //We must make it Dynamic
			PreparedStatement st = con.prepareStatement(query);
			System.out.println(query);
			st.setString(1, cname);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
			{
				System.out.println("inside Fething");
				int Cno = rd.getInt(1);
				String Tname = rd.getString(2);
				String Temail = rd.getString(3);
				
				obj.setCourseUID(Cno);
				obj.setTeacherName(Tname);
				obj.setTemail(Temail);
				
				flag = true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return(flag);
	}
	
	
}