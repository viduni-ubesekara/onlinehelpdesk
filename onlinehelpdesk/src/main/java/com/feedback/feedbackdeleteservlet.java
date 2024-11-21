package com.feedback;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.feedbackDBUtil;


/**
 * Servlet implementation class feedbackdeleteservlet
 */
@WebServlet("/feedbackdeleteservlet")
public class feedbackdeleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String feedbackid = request.getParameter("feedbackid");
		boolean isTrue;
		
		isTrue = feedbackDBUtil.deleteFeedback(feedbackid);
		
		if (isTrue == true) {
			 request.getSession().invalidate(); 
			 
			// Display a JavaScript message
			    response.setContentType("text/html");
			    PrintWriter out = response.getWriter();
			    out.println("<html><body>");
			    out.println("<script type='text/javascript'>");
			    out.println("alert('Feedback deleted. Please add new Feedback.');");
			    out.println("window.location.href='home.jsp';"); 
			    out.println("</script>");
			    out.println("</body></html>");
		}
		else {
			
			List<feedback> feedbackDetails = feedbackDBUtil.getFeedbackDetails(feedbackid);
			request.setAttribute("feedbackDetails", feedbackDetails);
			
			// Display a JavaScript error message
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println("<html><body>");
		    out.println("<script type='text/javascript'>");
		    out.println("alert('Cannot delete .');");
		    out.println("window.location.href='feedbackdetailview.jsp';"); // Redirect to user profile page
		    out.println("</script>");
		    out.println("</body></html>");
		}
	}

}
