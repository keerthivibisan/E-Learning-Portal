package databaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Eportal.servlet.DataBaseDetails;
import Eportal.servlet.NavbarProfileInfo;

public class CourseDetails extends DataBaseDetails {
	
	public boolean CourseDetails(String cname, CourseDetailsPojo obj)
	{
		System.out.println("Inside DB");
		System.out.println("Here qwe Go: "+cname);
		boolean flag = false;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			String query = "select Cno,Tname,Temail from courses,teacher where courses.UploaderTno=teacher.Tno and Cname like ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, cname);
			System.out.println(query);
			
			ResultSet rd = st.executeQuery();
			System.out.println("Above while Loop");
			System.out.println(rd);
			while(rd.next())
			{
				System.out.println("inside Fetching data");
				int Cno = rd.getInt(1);
				obj.setCid(Cno);
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

