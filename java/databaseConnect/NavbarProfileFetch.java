package databaseConnect;

import java.sql.*;

import Eportal.servlet.NavbarProfileInfo;


public class NavbarProfileFetch {
	
	String url = "jdbc:mysql://localhost:3306/ePortal";
	String dbname = "root";
	String dbpass = "vibi123";

	public boolean ProfileFetch(String email,NavbarProfileInfo obj)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbname,dbpass);
			String query ="select * from studentdetails where email = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
			{
				String name = rs.getString(1);
				int rollno = rs.getInt(5);
				String pnumber = rs.getString(3);
				
				obj.setName(name);
				obj.setRollNo(rollno);
				obj.setPNumber(pnumber);
				obj.setEmail(email);
				flag=true;
			}
			
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return(false);
	}
	
	public boolean TprofileInfoFetch(String Temail,NavbarProfileInfo obj)
	{
		boolean flag = false;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			String query="select * from teacher where Temail = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, Temail);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
			{
				int TuID = rd.getInt(1);
				String Tname = rd.getString(2);
				String Tcontact = rd.getString(3);
				String email = rd.getString(4);
				
				obj.setRollNo(TuID);
				obj.setName(Tname);
				obj.setPNumber(Tcontact);
				obj.setEmail(email);
				
				flag = true;
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
