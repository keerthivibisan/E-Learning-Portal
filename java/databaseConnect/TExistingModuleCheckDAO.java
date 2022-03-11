package databaseConnect;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;
import Eportal.servlet.FileUploadInfoCarrier;

public class TExistingModuleCheckDAO extends DataBaseDetails{
	
	public boolean CheckExistingCourse(FileUploadInfoCarrier obj)
	{
		int Tid = obj.getUID();
		int Cid = obj.getCid();
		
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from courses where UploaderTno = ? and Cno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Tid);
			st.setInt(2, Cid);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
			{
				String Fpath = rd.getString(3);
				obj.setFpath(Fpath);
				flag = true;
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
