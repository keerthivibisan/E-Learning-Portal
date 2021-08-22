package databaseConnect;

import java.sql.*;

public class StuProfileUpdate {

	String url = "jdbc:mysql://localhost:3306/eportal";
	String dbname = "root";
	String dbpass = "vibi123";
	
	public boolean UpdateContact(String Email, String Contact)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "update studentdetails set contact = ? where email = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, Contact);
			st.setString(2, Email);
			
			int c = st.executeUpdate();
			System.out.println(c+" / Contact Updated");
			flag = true;
			
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
