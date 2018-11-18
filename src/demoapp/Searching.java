package demoapp;

import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import demoapp.Searchingdo;
/**
 * Servlet implementation class Logging
 */
@WebServlet("/Searching")
public class Searching extends HttpServlet {
	
	
	String sql="select * from books where bookname=?";
	 String url="jdbc:mysql://localhost:3306/logincredentials";
	  String username="root";
	  String pas="";
	
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			PrintWriter out = response.getWriter();
			 String bookname = request.getParameter("book");
//			  String password = request.getParameter("pass");
			  
			  Searchingdo dao=new Searchingdo();  
			  
		
			 if(dao.check(bookname))
			  {
				  HttpSession session=request.getSession();
				  session.setAttribute("username", bookname);
				  
				  response.sendRedirect("searchresult.jsp");
				 
			  }
			  else
			  {
				  RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				   out.println("<font color=red>Invalid username or password.To create new account click on register</font>");
				   rd.include(request, response);
				 // response.sendRedirect("login.jsp");
				  
			  }
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		
}
