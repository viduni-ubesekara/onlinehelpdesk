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
 * Servlet implementation class feedbackviewservlet
 */
@WebServlet("/feedbackviewservlet")
public class feedbackviewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				
				String studentid = request.getParameter("studentid");
				
				boolean isTrue;
				
				isTrue =feedbackDBUtil.validate(studentid);
				
				if(isTrue == true) {
					
					 List<feedback> feedbackDetails = feedbackDBUtil.getFeedbackDetails2(studentid);
				     request.setAttribute("feedbackDetails", feedbackDetails);
					
			
					RequestDispatcher dis = request.getRequestDispatcher("feedbackdetailview.jsp");
					dis.forward(request, response);
				}
				else
				{
					out.println("<script type='text/javascript'>");
					out.print("alert('Your student is incorrect');");
					out.println("location = 'feedbacksearch.jsp'");
					out.println("</script>");
				}
	}

}
