package databaseConnect;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;

public class TGoogleRegister extends DataBaseDetails
{
	
	public boolean TGoogleRegister(String name, String email)
	{
		boolean flag = false;
		
		DATEGENERATOR date = new DATEGENERATOR();
		String d = date.getDate();
		
		int c = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "insert into teacher values(null ,?, null, ?, null, ?, null)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, d);
			c = st.executeUpdate();
			System.out.println(c);
			
			flag = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return(flag);
	}
}
