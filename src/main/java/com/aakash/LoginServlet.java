package com.aakash;

//Import necessary Libraries
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;  
import java.sql.*;  
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

public class LoginServlet extends HttpServlet {

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  
		  response.setContentType("text/html");
	       PrintWriter out=response.getWriter();
		  
	     //Retrieve username and Password
	        String name=request.getParameter("name");
	        String password=request.getParameter("password");
		  
	      try {
			
	    	  Class.forName("com.mysql.jdbc.Driver");  
	            //Create Connection
	            Connection con=DriverManager.getConnection(  
	                    "jdbc:mysql://localhost:3306/registration?characterEncoding=latin1&useConfigs=maxPerformance","root","root");  
	    	  
	            //Create Statement for database query
	            PreparedStatement ps = con.prepareStatement("select * from register1 where name=? and password=?");
	            ps.setString(1, name);
	            ps.setString(2, password);
	            //execute query
	            ResultSet rs =ps.executeQuery();
	            //check if result exists
	            
	            if(rs.next()) {
	                //if exists, then create session attribute and redirect user to authenticated page
	                HttpSession session=request.getSession();
	                session.setAttribute("logindetail", name+password);
	                response.sendRedirect("lock.jsp");
	            }
	            
	            else{
	                //if not exists, prompt user.
	                out.print("<h4>Sorry, username or password is incorrect!</h4>");
	                request.getRequestDispatcher("login.html").include(request, response);
	            } 
	            
	    	  
		} catch (Exception e2) {
			System.out.println(e2);
			
		}  
		  
	      out.close();  
		  
	  }
}