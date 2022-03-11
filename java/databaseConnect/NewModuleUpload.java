package databaseConnect;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;
import Eportal.servlet.FileUploadInfoCarrier;

public class NewModuleUpload extends DataBaseDetails{

	public boolean CourseRegister(FileUploadInfoCarrier obj)
	{
		boolean flag = false;
		
		//Default
		String status = "In-Active";
		
		DATEGENERATOR date = new DATEGENERATOR();
		String Udate = date.getDate();
		try
		{
			String Cname = obj.getCname();
			int UID = obj.getUID();
			String Fpath = obj.getFpath();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			String query = "insert into courses values(null,?,?,?,?,?,' ',?,?)";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, Cname);
			st.setString(2, Fpath);
			st.setInt(3, UID);
			st.setString(4, status);
			st.setString(5, Udate);
			st.setString(6, obj.getDesc());
			st.setString(7, obj.getImgurl());
			
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
