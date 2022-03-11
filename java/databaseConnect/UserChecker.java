package databaseConnect;

import java.sql.*;//1.

import com.admin.GoogleSignINBlock;

import Eportal.servlet.DataBaseDetails;
public class UserChecker extends DataBaseDetails{
	
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
	
	//Teachers Google Login User Checker
	public boolean TExistingCheck(String Email, GoogleSignINBlock block)
	{
		boolean flag = false;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from teacher where Temail = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, Email);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
			{
				String BLK = rd.getString(7);
				block.setBlock(BLK);
				flag = true;
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return(flag);
	}

}
