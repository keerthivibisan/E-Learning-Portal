package databaseConnect;
import java.sql.*;

import Eportal.servlet.DataBaseDetails;
import Eportal.servlet.FileUploadInfoCarrier;
public class TeacherCourseEdit extends DataBaseDetails
{
	public boolean UpdateCourseDetails(FileUploadInfoCarrier obj)
	{
		boolean flag = false;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			String query = "update courses set img = ?, Cname=?, detail=? where Cno =?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, obj.getImgurl());
			st.setString(2, obj.getCname());
			st.setString(3, obj.getDesc());
			st.setInt(4, obj.getCid());
			
			int c = st.executeUpdate();
//			System.out.println("Rows/ "+c);
			if(c==1)
			{
				flag = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return(flag);
	}
	
	public boolean UpdateCourseDetailsAdmin(FileUploadInfoCarrier obj)
	{
		boolean flag = false;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			String query = "update courses set img = ?, Cname=?, detail=?, UploaderTno=?, status=?, jspfile=? where Cno =?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, obj.getImgurl());
			st.setString(2, obj.getCname());
			st.setString(3, obj.getDesc());
			st.setInt(4, obj.getUID());
			st.setString(5, obj.getStatus());
			st.setString(6, obj.getJsp());
			st.setInt(7, obj.getCid());
			
			int c = st.executeUpdate();
			System.out.println("Rows/ "+c);
			if(c==1)
			{
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
