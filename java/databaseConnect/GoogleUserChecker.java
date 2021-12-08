package databaseConnect;

import java.sql.*;//1.

import com.admin.GoogleSignINBlock;
public class GoogleUserChecker {
	
	String url = "jdbc:mysql://10.10.110.204:3306/eportal";
	String dbname = "test";
	String dbpass = "test";
	
	public boolean ExistingUserCheck(String Email, GoogleSignINBlock obj)
	{
		
		String query = "select action from studentdetails where email=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbname,dbpass);//3.
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, Email);
			ResultSet rd = st.executeQuery();
			if(rd.next())
			{
				String action = rd.getString(1);
				System.out.println(action+ " ---> Block Status");
				obj.setBlock(action);
				return(true);
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
