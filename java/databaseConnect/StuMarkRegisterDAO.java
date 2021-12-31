package databaseConnect;
import java.sql.*;

import Eportal.servlet.DataBaseDetails;
import Eportal.servlet.GamifyJSPScoreCarrier;
public class StuMarkRegisterDAO extends DataBaseDetails
{
	public void RegisterMark(GamifyJSPScoreCarrier obj)
	{
		DATEGENERATOR date = new DATEGENERATOR();
		String d = date.getDate();  
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			String query = "insert into stucoursemarks values(?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, obj.getCno());
			st.setInt(2, obj.getSno());
			st.setInt(3, obj.getScore());
			st.setString(4, d);
			
			int c = st.executeUpdate();
			System.out.println(c+ "/ Mark Registered Successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
