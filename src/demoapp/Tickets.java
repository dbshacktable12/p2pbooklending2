package demoapp;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Store
 */
@WebServlet("/Tickets")
public class Tickets extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		//int k=0;
		 //String votername = request.getParameter("votername");
		 //String partyname = request.getParameter("parties");
		 
		 String name = request.getParameter("myname");
		 String date = request.getParameter("date");
		 String num = request.getParameter("no");
		 String from = request.getParameter("from");
		 String to = request.getParameter("to");
		 

		 try {
			    Class.forName("com.mysql.jdbc.Driver");
			  

			    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logincredentials", "root", ""); 

			    /*String query2="select count(Username) from votes where Username=\"venkat\"";
			    Statement st=(Statement) con.createStatement();
			    ResultSet rs=st.executeQuery(query2);
			    rs.next();
			     String count=rs.getString("count(Username)");
			    
			    	
			    st.close();
			    */
			    String query = "insert into journey values(?,?,?,?,?)";
			    
			    
			    PreparedStatement ps = con.prepareStatement(query);
			    //if((count.equals("1")))
			    //{
			    ps.setString(1, name);
			    ps.setString(2, date);
			    ps.setString(3, num);
			    ps.setString(4, from);
			    ps.setString(5, to);
			    ps.executeUpdate(); // execute it on test database
			    System.out.println("successfuly inserted");
			    //k=1;
			    //}
			    ps.close();
			    con.close();
			   }
		  		catch (Exception e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			   }
		 
		 RequestDispatcher rd = request.getRequestDispatcher("welcomeuser.jsp");
		 //if(k==1)
		   out.println("<font color=green>Successfully booked your Ticket<br></font>");
		 //else
			// out.println("<font color=red>vote can be submitted only once<br></font>");
		   rd.include(request, response);
		 
		  


		
	}

	

}

