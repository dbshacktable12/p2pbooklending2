package demoapp;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 try {
			    Class.forName("com.mysql.jdbc.Driver");
			  
			    /*HttpSession session=request.getSession();
			    if(session.getAttribute("username")==null)
				{
					response.sendRedirect("login.jsp");
				}*/
			    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logincredentials", "root", ""); 
			    
			    String z = request.getParameter("bookname");
			    PrintWriter out = response.getWriter();
			    //out.println("z");
			    String query ="SELECT * FROM journey WHERE name='"+z+"'";
			    Statement st=(Statement) con.createStatement();
			    ResultSet rs=st.executeQuery(query);
			    rs.next();
			    
			    out.println("<table border='2'>");
			    out.println("<tr>");
			    out.println("<th>Date</th>");
			    out.println("<th>Number of Seats Booked</th>");
			    out.println("<th>Starting Point</th>");
			    out.println("<th>Destination</th>");
			    out.println("</tr>");
			   
			    while(rs.next())
			    {
			    String mdate=rs.getString("date");
			    String mnum=rs.getString("num");
			    String mfrom=rs.getString("From");
			    String mto=rs.getString("To");
			    
			    out.println("<tr>");
			    out.println("<td>"+mdate+"</td>");
			    out.println("<td>"+mnum+"</td>");
			    out.println("<td>"+mfrom+"</td>");
			    out.println("<td>"+mto+"</td>");
			    out.println("</tr>");
			    }
			    //if(rs.next()) {
			    //out.println("</table>");
//			    }
//			    if(rs.next()) {
//			    	out.println("<h3>No Matching Values Found</h3>");
//			    }
			    //String bjp=rs.getString("count(Username)");
			    //System.out.println(bjp);
			    
/*			    
			    String query2 ="SELECT count(Username) FROM votes WHERE party=\"CONGRESS\"";
			     st=(Statement) con.createStatement();
			     rs=st.executeQuery(query2);
			    rs.next();
			    String congress=rs.getString("count(Username)");
			    System.out.println(congress);
			    
			    
			    String query3 ="SELECT count(Username) FROM votes WHERE party=\"CPI\"";
			     st=(Statement) con.createStatement();
			     rs=st.executeQuery(query3);
			    rs.next();
			    String cpi=rs.getString("count(Username)");
			    System.out.println(cpi);
			    
			    String query4 ="SELECT count(Username) FROM votes WHERE party=\"CPM\"";
			     st=(Statement) con.createStatement();
			     rs=st.executeQuery(query4);
			    rs.next();
			    String cpm=rs.getString("count(Username)");
			    System.out.println(cpm);
			    
			    String query5 ="SELECT count(Username) FROM votes WHERE party=\"JANATADALL\"";
			     st=(Statement) con.createStatement();
			     rs=st.executeQuery(query5);
			    rs.next();
			    String janatadall=rs.getString("count(Username)");
			    System.out.println(janatadall);
*/			    
				 
				//  out.println("BJP  : "+bjp +"<br>" );
				  
			    st.close();
			    con.close();
		 }
		 catch (Exception e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			   }
		
		// RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		 
		  // rd.forward(request, response);
	}

	

}

