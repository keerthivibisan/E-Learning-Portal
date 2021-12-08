package databaseConnect;

import java.sql.*;

import Eportal.servlet.NavbarProfileInfo;


public class CourseInfoFetch {

	String url = "jdbc:mysql://10.10.110.204:3306/eportal";
	String dbname = "test";
	String dbpass = "test";
	
	
	public boolean CourseDetails(String cname, NavbarProfileInfo obj)
	{
		boolean flag = false;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			String query = "select Cno,Tname,Temail from courses,teacher where courses.UploaderTno=teacher.Tno and Cname = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, cname);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
			{
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
