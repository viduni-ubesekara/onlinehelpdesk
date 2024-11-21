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
 * Servlet implementation class ticketviewservlet
 */
@WebServlet("/ticketviewservlet")
public class ticketviewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//if login unsuccess, show javascript error and redirect to the login page
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String studentid = request.getParameter("studentid");//catch the event type
		
		boolean isTrue;
		
		isTrue =ticketraiseDBUtil.validate(studentid);
		
		if(isTrue == true) {
			
			 List<ticketraise> ticketDetails = ticketraiseDBUtil.getTicketDetails2(studentid);
		     request.setAttribute("ticketDetails", ticketDetails);
			
			//navigate to another page
			RequestDispatcher dis = request.getRequestDispatcher("ticketdetailsview.jsp");
			dis.forward(request, response);
		}
		else
		{
			out.println("<script type='text/javascript'>");
			out.print("alert('Your student is incorrect');");
			out.println("location = 'ticketsearch.jsp'");
			out.println("</script>");
		}
		
		
	}

}
