package databaseConnect;
import java.sql.*;
import java.util.Random;



public class RegisterData {
	
	public static int generateCode()
	{
		Random rnd = new Random();
		int code = rnd.nextInt(99999);
		return(code);
	}

	int Sno = generateCode();
	String url = "jdbc:mysql://localhost:3306/ePortal";
	String dbname = "root";
	String dbpass = "vibi123";
	String query = "insert into studentdetails values(?,?,?,?,?)";
	
	public boolean RegisterUserData(String UserName,String phone,String Email,String Finalpassword)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbname,dbpass);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, UserName);
			st.setString(2, Finalpassword);
			st.setString(3, phone);
			st.setString(4,Email);
			st.setInt(5, Sno);
			int c = st.executeUpdate();
			System.out.println(c+"/rows affected");
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return(true);
	}
	
}
