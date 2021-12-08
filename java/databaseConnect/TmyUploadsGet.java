package databaseConnect;

import java.sql.*;
import java.util.LinkedList;

import Eportal.servlet.TmyUploadsCarrier;

public class TmyUploadsGet {

	String url = "jdbc:mysql://10.10.110.204:3306/eportal";
	String dbname = "test";
	String dbpass = "test";
	
	public boolean getMyUploads(int UID, TmyUploadsCarrier obj)
	
	{
		boolean flag = false;
		
		LinkedList <Integer> CId = new LinkedList <Integer> ();
		LinkedList <String> name = new LinkedList <String> ();
		LinkedList <String> path = new LinkedList <String> ();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from courses where UploaderTno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, UID);
			
			ResultSet rd = st.executeQuery();
			
			while(rd.next())
			{
				int CID = rd.getInt(1);
				String Cname = rd.getString(2);
				String Fpath = rd.getString(3);
				
				//Adding in linked list
				CId.offer(CID);
				name.offer(Cname);
				path.offer(Fpath);
				
//				System.out.println(CId+"|"+name+"|"+path);
				
				flag = true;
			}
			
			//Setting LinkedList to POJO Class
			obj.setCId(CId);
			obj.setCname(name);
			obj.setCpath(path);
			
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
