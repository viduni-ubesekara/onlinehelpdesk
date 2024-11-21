package com.ticketraise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.ticketraiseDBUtil;

/**
 * Servlet implementation class ticketinsertservlet
 */
@WebServlet("/ticketinsertservlet")
public class ticketinsertservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		    
		 	String name = request.getParameter("name");
		 	String email = request.getParameter("email");
			String studentid = request.getParameter("studentid");
			String faculty = request.getParameter("faculty");
			String phone = request.getParameter("phone");
			String inquiry = request.getParameter("inquiry");
			String subinquiry = request.getParameter("subinquiry");
			String subject = request.getParameter("subject");
			String message = request.getParameter("message");
			
			
			
			
			
		
		boolean isTrue;//catch the return value by the variable
		
		isTrue = ticketraiseDBUtil.insertticket(name,email,studentid,faculty,phone,inquiry,subinquiry,subject,message);
		
		if(isTrue == true) {//check the database connection success or not
			 out.println("<script type=\"text/javascript\">");
			    out.println("alert(' Ticket Raise successfully!');");
			    out.println("window.location.href = 'home.jsp';"); // Redirect to your registration page
			    out.println("</script>");
		} else {
		    // Replace the RequestDispatcher with a JavaScript alert
		   
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Ticket Raise Unsuccessfully!');");
		    out.println("window.location.href = 'ticketraise.jsp';"); // Redirect to your registration page
		    out.println("</script>");
		}
	}

}
