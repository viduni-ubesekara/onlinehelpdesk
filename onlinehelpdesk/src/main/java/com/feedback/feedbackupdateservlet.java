package com.feedback;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.feedbackDBUtil;


/**
 * Servlet implementation class feedbackupdateservlet
 */
@WebServlet("/feedbackupdateservlet")
public class feedbackupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		
		 String feedbackid = request.getParameter("feedbackid");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String studentid = request.getParameter("studentid");
			String phone = request.getParameter("phone");
			String faculty = request.getParameter("faculty");
			String message = request.getParameter("message");
			String rating = request.getParameter("rating");
		
		boolean isTrue;
		
		isTrue = feedbackDBUtil.updatefeedback(feedbackid,name,email,studentid,faculty,phone,message,rating);
		
		 if (isTrue) {
	            List<feedback> feedbackDetails = feedbackDBUtil.getFeedbackDetails(feedbackid);
	            request.setAttribute("feedbackDetails", feedbackDetails);
	            
	            out.println("<script>alert('Update successful!');</script>");
	            
	            RequestDispatcher dis = request.getRequestDispatcher("feedbackdetailview.jsp");
	            dis.include(request, response);
	        } else {
	        	List<feedback> feedbackDetails = feedbackDBUtil.getFeedbackDetails(feedbackid);
	            request.setAttribute("feedbackDetails", feedbackDetails);
	          
	            out.println("<script>alert('Update unsuccessful. Please try again.');</script>");
	            
	            RequestDispatcher dis = request.getRequestDispatcher("feedbackdetailview.jsp");
	            dis.forward(request, response);
	        }
	}

}
