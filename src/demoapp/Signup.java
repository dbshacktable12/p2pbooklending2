package demoapp;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 PrintWriter out = response.getWriter();
		 String fname = request.getParameter("input3");
		  String username = request.getParameter("input1");
		  String password = request.getParameter("input2");
		  String lname = request.getParameter("input4");
		  String email = request.getParameter("input5");
		  
		  if (fname.isEmpty() || username.isEmpty() || password.isEmpty() || lname.isEmpty() || email.isEmpty()) {
			   RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			   out.println("<font color=red>Please fill all the fields</font>");
			   rd.include(request, response);
		  }
		  else
		  {
			  try {
				    Class.forName("com.mysql.jdbc.Driver");
				  

				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logincredentials", "root", ""); 

				    String query = "insert into credentials values(?,?,?,?,?)";
				    PreparedStatement ps = con.prepareStatement(query); 

				    ps.setString(1, username);
				    ps.setString(2, password);
				    ps.setString(3, fname);
				    ps.setString(4, lname);
				    ps.setString(5, email);

				    ps.executeUpdate(); // execute it on test database
				    out.println("successfuly inserted");
				    ps.close();
				    con.close();
				   }
			  		catch (Exception e) {
				    // TODO Auto-generated catch block
				    e.printStackTrace();
				   }
			  
			  
			  RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			  out.println("<font color=green>Successfully registered<br></font>");
			   rd.forward(request, response);


		  }
		  
		  
	}

	

}


