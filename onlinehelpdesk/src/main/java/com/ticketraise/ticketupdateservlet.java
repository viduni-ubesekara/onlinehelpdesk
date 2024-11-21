package com.ticketraise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.ticketraiseDBUtil;

/**
 * Servlet implementation class ticketupdateservlet
 */
@WebServlet("/ticketupdateservlet")
public class ticketupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		//save the details that entered by student
		 String ticketid = request.getParameter("ticketid");//id is the parameter name of ID in studentprofile page inside url tag
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String studentid = request.getParameter("studentid");
			String phone = request.getParameter("phone");
			String faculty = request.getParameter("faculty");
			String inquiry = request.getParameter("inquiry");
			String subinquiry = request.getParameter("subinquiry");
			String subject = request.getParameter("subject");
			String message = request.getParameter("message");
		
		boolean isTrue;
		
		isTrue = ticketraiseDBUtil.updateticket(ticketid,name,email,studentid,faculty,phone,inquiry,subinquiry,subject,message);//parameters used in updatestudent method in studentDBUtil class
		
		 if (isTrue) {
	            List<ticketraise> ticketDetails = ticketraiseDBUtil.getTicketDetails(ticketid);
	            request.setAttribute("ticketDetails", ticketDetails);
	            // JavaScript message for success
	            out.println("<script>alert('Update successful!');</script>");
	            // Include the JSP page with the message
	            RequestDispatcher dis = request.getRequestDispatcher("ticketdetailsview.jsp");
	            dis.include(request, response);
	        } else {
	        	 List<ticketraise> ticketDetails = ticketraiseDBUtil.getTicketDetails(ticketid);
		            request.setAttribute("ticketDetails", ticketDetails);
	            // JavaScript message for failure
	            out.println("<script>alert('Update unsuccessful. Please try again.');</script>");
	            // Forward to userprofile.jsp for an unsuccessful update
	            RequestDispatcher dis = request.getRequestDispatcher("ticketdetailsview.jsp");
	            dis.forward(request, response);
	        }
	}

}
