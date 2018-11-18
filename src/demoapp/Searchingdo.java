package demoapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Searchingdo {
	String sql="select * from books where bookname=?";
	 String url="jdbc:mysql://localhost:3306/logincredentials";
	  String username="root";
	  String pas="";
	public boolean check(String book)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pas);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, book);
//			st.setString(2, password);
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

