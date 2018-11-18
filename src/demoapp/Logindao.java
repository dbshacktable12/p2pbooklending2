package demoapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Logindao {
	String sql="select * from credentials where Username=? and Password=?";
	 String url="jdbc:mysql://localhost:3306/logincredentials";
	  String username="root";
	  String pas="";
	public boolean check(String uname,String password)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pas);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, password);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}

