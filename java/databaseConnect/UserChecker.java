package databaseConnect;

import java.sql.*;//1.
public class UserChecker {
	
	String url = "jdbc:mysql://localhost:3306/ePortal";
	String dbname = "root";
	String dbpass = "vibi123";
	
	public boolean ExistingUserCheck(String Email)
	{
		
		String query = "select*from studentdetails where email=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//2.
			Connection con = DriverManager.getConnection(url,dbname,dbpass);//3.
			PreparedStatement st = con.prepareStatement(query);//4.For Dynamic CRUD Operations
			st.setString(1, Email);//SETTING Run time value
			ResultSet rd = st.executeQuery();//5.
			if(rd.next())//6.
			{
				return(true);//if found return TRUE
			}
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Return false if not found
		return(false);
		
	}

}
