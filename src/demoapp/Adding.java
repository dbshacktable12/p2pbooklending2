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
@WebServlet("/Adding")
public class Adding extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 PrintWriter out = response.getWriter();
		 String bname = request.getParameter("bookname");
		  String aname = request.getParameter("auth");
		  String cost = request.getParameter("cost");
		  String dept = request.getParameter("dept");
//		  String email = request.getParameter("input5");
//		  double id = Math.random() ;
		  
		  if (bname.isEmpty() || aname.isEmpty() || cost.isEmpty() || dept.isEmpty() ) {
			   RequestDispatcher rd = request.getRequestDispatcher("addbook.jsp");
			   out.println("<font color=red>Please fill all the fields</font>");
			   rd.include(request, response);
		  }
		  else
		  {
			  try {
				    Class.forName("com.mysql.jdbc.Driver");
				  

				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logincredentials", "root", ""); 

				    String query = "insert into books values(?,?,?,?)";
				    PreparedStatement ps = con.prepareStatement(query); 

//				    ps.setDouble(1, id);
				    ps.setString(1, bname);
//				    ps.setString(2, );
				    ps.setString(2, aname);
				    ps.setString(3, cost);
				    ps.setString(4, dept);

				    ps.executeUpdate(); // execute it on test database
				    out.println("Successfuly Added book");
				    ps.close();
				    con.close();
				   }
			  		catch (Exception e) {
				    // TODO Auto-generated catch block
				    e.printStackTrace();
				   }
			  
			  	
			  RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			  out.println("<font color=green>Successfully registered<br></font>");
			   rd.forward(request, response);


		  }
		  
		  
	}

	

}


