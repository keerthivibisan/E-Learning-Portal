package databaseConnect;

import java.sql.*;

public class LoginVerification {
	
	String url = "jdbc:mysql://localhost:3306/ePortal";
	String dbname = "root";
	String dbpass= "vibi123";
	
	public boolean LoginVerify(String email, String pass)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbname,dbpass);
			//As it is dynamic
			String query = "select email,password from studentdetails where email=? and password=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, pass);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next()) {
				return(true);
			}
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return(false);
	}
	
	public boolean TLoginVerify(String Temail,String Tpass)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from teacher where Temail=? and Tpassword=?";
			
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, Temail);
			st.setString(2, Tpass);
			
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
