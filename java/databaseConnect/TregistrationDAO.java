package databaseConnect;

import java.sql.*;

import Eportal.servlet.TregistrationInfoCarrier;

public class TregistrationDAO {

	String url = "jdbc:mysql://10.10.110.204:3306/eportal";
	String dbname = "test";
	String dbpass = "test";
	
	public boolean RegisterTeacher(TregistrationInfoCarrier obj)
	{
		boolean flag = false;
		
		DATEGENERATOR date = new DATEGENERATOR();
		String Tdate = date.getDate();
		
		try
		{
			String Tname = obj.getTname();
			String Tcontact = obj.getTcontact();
			String Temail = obj.getTemail();
			String Tpass = obj.getTpass();
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbname,dbpass);
			String query="insert into teacher values(null,?,?,?,?,?,null)";
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, Tname);
			st.setString(2, Tcontact);
			st.setString(3, Temail);
			st.setString(4, Tpass);
			st.setString(5, Tdate);
			
			
			@SuppressWarnings("unused")
			int c = st.executeUpdate();
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
