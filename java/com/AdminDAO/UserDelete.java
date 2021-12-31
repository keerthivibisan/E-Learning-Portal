package com.AdminDAO;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;

public class UserDelete extends DataBaseDetails {
	
	//Delete a student User
	public boolean deleteStudent(String Email, int UID)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "delete from studentdetails where email = ? and Sno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, Email);
			st.setInt(2, UID);
			
			int c = st.executeUpdate();
			
			System.out.println(c+"/ Rows deleted");
			
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
	
	//Delete a Teacher User
	public boolean TUserDelete(String Temail, int Tid)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "delete from teacher where Temail = ? and Tno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,Temail);
			st.setInt(2, Tid);
			
			int c = st.executeUpdate();
			
			System.out.println(c+"/Teacher table row's Affected");
			
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
	
	//Delete a Course
	public boolean CourseDelete(int CourseId, int Tid)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "delete from courses where Cno = ? and UploaderTno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1,CourseId);
			st.setInt(2, Tid);
			
			int c = st.executeUpdate();
			
			System.out.println(c+"/Courses table row's Affected");
			
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
	
	//Delete a student REGISTERED COURSE
	public boolean StuRegisterCourseDelete(int CourseId, int Sid)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "delete from sturegistercourse where Cno = ? and Sno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1,CourseId);
			st.setInt(2, Sid);
			
			int c = st.executeUpdate();
			
			System.out.println(c+"/stuCoursesRegister table row's Affected");
			
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
	
	//Delete a student REGISTERED COURSE
	public boolean StuVideoSeenDelete(String Vid, int CourseId, int Sid)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			//System.out.println(Vid+"||"+CourseId+"||"+Sid);
			String query = "delete from stuvideoregister where VideoId = ? and Sid = ? and Cid = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, Vid);
			st.setInt(2, Sid);
			st.setInt(3,CourseId);
			
			int c = st.executeUpdate();
			
			System.out.println(c+" /stuSeenVideo table row's Affected");
			
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
	
	//Delete a student Marks COURSE
		public boolean StuMarkDelete(int Sid, int CourseId)
		{
			boolean flag = false;
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, dbname, dbpass);
				
				String query = "delete from stucoursemarks where Sno = ? and Cno = ?";
				
				PreparedStatement st = con.prepareStatement(query);
				st.setInt(1, Sid);
				st.setInt(2,CourseId);
				
				int c = st.executeUpdate();
				
				System.out.println(c+" /stuSeenVideo table row's Affected");
				
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
