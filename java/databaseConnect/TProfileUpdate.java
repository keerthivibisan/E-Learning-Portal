package databaseConnect;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;

public class TProfileUpdate extends DataBaseDetails{
	
	public boolean UpdateContact(int id, String Contact)
	{
		boolean flag = false;
		int c = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "update teacher set Tcontact = ? where Tno = ?";
			
			PreparedStatement st = con.prepareStatement(query); 
			
			st.setString(1, Contact);
			st.setInt(2, id);
			
			c = st.executeUpdate();
			
			System.out.println(c+ "/ Rows Updated");
			
			flag = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return(flag);
	}
	
}
