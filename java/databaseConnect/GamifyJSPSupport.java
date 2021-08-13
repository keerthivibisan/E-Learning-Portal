package databaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Eportal.servlet.GamifyJSPScoreCarrier;

public class GamifyJSPSupport {
	
	//Database Settings
	String url = "jdbc:mysql://localhost:3306/eportal";
	String dbname = "root";
	String dbpass= "vibi123";
		
	public boolean AlreadyAttended(int Sid,GamifyJSPScoreCarrier obj)
	{
		boolean flag = false;
			
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
				
			String query = "select * from GamifyRegister where Sid = ?";
				
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Sid);
				
			ResultSet rd = st.executeQuery();
				
			if(rd.next())
			{
				int Score = rd.getInt(2);
				//System.out.print(Score);
				obj.setScore(Score);
				
				flag = true;
				//System.out.println("Already present");
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
