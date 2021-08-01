package databaseConnect;

import java.sql.*;

public class MyLearnings {
	
	String url = "jdbc:mysql://localhost:3306/ePortal";
	String dbname = "root";
	String dbpass = "vibi123";

	public boolean displayCourse(int Sno)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from sturegistercourse where Sno=? and Cname='JAVA'";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Sno);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
			{
				flag = true;
			}
			
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
