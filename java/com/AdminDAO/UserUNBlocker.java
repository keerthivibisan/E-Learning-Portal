package com.AdminDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserUNBlocker {

	String url = "jdbc:mysql://localhost:3306/eportal";
	String dbname = "root";
	String dbpass = "vibi123";
	
	public boolean StuUserUNBlock(int Sid)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "update studentdetails set action = null where Sno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Sid);
			
			int c = st.executeUpdate();
			
			System.out.println(c+" /User UN-blocked");
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
	
	//----- Teacher's ------
	public boolean TUserUNBlock(int Tid)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "update teacher set Action = null where Tno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Tid);
			
			int c = st.executeUpdate();
			
			System.out.println(c+" /User UN-blocked");
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
