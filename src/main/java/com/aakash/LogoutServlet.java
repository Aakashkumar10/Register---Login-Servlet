package com.aakash;

//Import necessary Libraries
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

public class LogoutServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
      out.print("<h4>you are successfully logged out!</h4>");

      request.getRequestDispatcher("index.html").include(request, response);
      //Destroy Session
      HttpSession session=request.getSession(true);
      session.invalidate();  
  }
}