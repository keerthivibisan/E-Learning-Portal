package databaseConnect;
import java.sql.*;
import java.util.Random;

import Eportal.servlet.DataBaseDetails;



public class RegisterData extends DataBaseDetails {
	
	public static int generateCode()
	{
		Random rnd = new Random();
		int code = rnd.nextInt(99999);
		return(code);
	}

	int Sno = generateCode();

	String query = "insert into studentdetails values(?,?,?,?,null,?,null)";
	
	public boolean RegisterUserData(String UserName,String phone,String Email,String Finalpassword)
	{
		try {
			DATEGENERATOR get = new DATEGENERATOR();
			String date = get.getDate();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbname,dbpass);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, UserName);
			st.setString(2, Finalpassword);
			st.setString(3, phone);
			st.setString(4,Email);
			st.setString(5, date);
			int c = st.executeUpdate();
			System.out.println(c+"/rows affected");
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return(true);
	}
	
}
