package databaseConnect;

import java.sql.*;

public class MyLearnings {
	
	String url = "jdbc:mysql://10.10.110.204:3306/eportal";
	String dbname = "test";
	String dbpass = "test";

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
