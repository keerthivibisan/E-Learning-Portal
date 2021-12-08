package com.AdminDAO;

import java.sql.*;

public class AdminVerify {

	String url = "jdbc:mysql://10.10.110.204:3306/eportal";
	String dbname = "test";
	String dbpass = "test";
	
	public boolean AdminLoginVerify(String Email, String Pass)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from adminlogin where AEmail = ? and Apassword = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, Email);
			st.setString(2, Pass);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
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
