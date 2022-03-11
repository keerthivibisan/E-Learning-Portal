package com.AdminDAO;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;
public class UserBlockCheck extends DataBaseDetails {
	
	//Student Block Check
	public boolean StuBlockCheck(int Sid)
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select action from studentdetails where Sno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Sid);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
			{
				if(rd.getString(1) == null)
				{
					//System.out.println(rd.getString(1));
					return(false);
				}
			}
			
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return(true);
	}
	
	//Teacher's Block Checker
	public boolean TBlockCheck(int Tid)
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select Action from teacher where Tno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Tid);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
			{
				if(rd.getString(1) == null)
				{
					//System.out.println(rd.getString(1));
					return(false);
				}
			}
			
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return(true);
	}
	
}
