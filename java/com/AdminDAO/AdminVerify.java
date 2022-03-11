package com.AdminDAO;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;

public class AdminVerify extends DataBaseDetails {

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
