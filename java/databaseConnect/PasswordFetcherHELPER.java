package databaseConnect;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;
import Eportal.servlet.PasswordHELPERCarrier;

public class PasswordFetcherHELPER extends DataBaseDetails{

	public boolean getPassword(PasswordHELPERCarrier fetch)
	{
		boolean flag = false;
		
		//Getting from POJO
		String Email = fetch.getEmail();
		String Contact = fetch.getContact();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select password from studentdetails where email= ? and contact= ?";
			
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1,Email);
			st.setString(2, Contact);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
			{
				String pass = rd.getString(1);
				fetch.setPassword(pass);
				//System.out.println(pass);
				flag = true;
			}
			
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			
		}
		
		return(flag);
	}
	
	public boolean getTPassword(PasswordHELPERCarrier fetch)
	{
		boolean flag = false;
		
		//Getting from POJO
		String Email = fetch.getEmail();
		String Contact = fetch.getContact();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select Tpassword from teacher where Temail= ? and Tcontact= ?";
			
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1,Email);
			st.setString(2, Contact);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
			{
				String pass = rd.getString(1);
				fetch.setPassword(pass);
				//System.out.println(pass);
				flag = true;
			}
			
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			
		}
		
		return(flag);
	}
	
}
