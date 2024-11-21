package com.feedback;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.feedbackDBUtil;


/**
 * Servlet implementation class feedbackinsertservlet
 */
@WebServlet("/feedbackinsertservlet")
public class feedbackinsertservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		    
		 	String name = request.getParameter("name");
		 	String email = request.getParameter("email");
			String studentid = request.getParameter("studentid");
			String faculty = request.getParameter("faculty");
			String phone = request.getParameter("phone");
			String message = request.getParameter("message");
			String rating = request.getParameter("rating");
			
			
			
			
		
		boolean isTrue;
		
		isTrue = feedbackDBUtil.insertfeedback(name,email,studentid,faculty,phone,message,rating);
		
		if(isTrue == true) {
			 out.println("<script type=\"text/javascript\">");
			    out.println("alert(' Feedback Add successfully!');");
			    out.println("window.location.href = 'home.jsp';");
			    out.println("</script>");
		} else {
		    
		   
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Feedback Add Unsuccessfully!');");
		    out.println("window.location.href = 'feedbackinsert.jsp';"); 
		    out.println("</script>");
		}
	}

}
