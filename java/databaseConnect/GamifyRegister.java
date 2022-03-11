package databaseConnect;

import java.util.Date;

import Eportal.servlet.DataBaseDetails;

import java.sql.*;

public class GamifyRegister extends DataBaseDetails {

	public String GetDate()
	{
		Date date = new Date();
		String n = date.toString();
		
		return(n);
	}
	
	public boolean AlreadyAttended(int Sid)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from gamifyregister where Sid = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Sid);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
			{
				flag = true;
				System.out.println("Already present");
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
	
	public boolean EnterMark(int Score, int Sid, String date)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,dbname,dbpass);
			
			String query = "insert into gamifyregister values(?,?,?)";
			
			PreparedStatement st = con.prepareStatement(query);
			
			st.setInt(1, Sid);
			st.setInt(2, Score);
			st.setString(3, date);
			
			int c = st.executeUpdate();
			System.out.println(c+"/ Row's Affected");
			
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
