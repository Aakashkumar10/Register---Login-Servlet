package com.aakash;

//Import necessary Libraries
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  

public class RegisterServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  

//Retrieve username and Password
String name=request.getParameter("name");  
String password=request.getParameter("password");  

try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
//Create Connection
Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/registration?characterEncoding=latin1&useConfigs=maxPerformance","root","root");  
  
//Create Statement for inserting details to table
PreparedStatement ps=con.prepareStatement(  
"insert into register1 values(?,?)");  
  
ps.setString(1,name);  
ps.setString(2,password);  
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered.... Please login to continue");  
request.getRequestDispatcher("index.html").include(request, response);
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
}  