package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.studentDBUtil;

/**
 * Servlet implementation class stprofiledeleteservlet
 */
@WebServlet("/stprofiledeleteservlet")
public class stprofiledeleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");//id the name of the input type of ID in stprofiledelete.jsp
		boolean isTrue;
		
		isTrue = studentDBUtil.deleteStudent(id);//catch the return value of istrue variable in deleteStudent method in studentDBUtil class
		
		if (isTrue == true) {
			 request.getSession().invalidate(); // Invalidate the session (log out the user)
			 
			// Display a JavaScript message
			    response.setContentType("text/html");
			    PrintWriter out = response.getWriter();
			    out.println("<html><body>");
			    out.println("<script type='text/javascript'>");
			    out.println("alert('Your account has been deleted. Please create a new account.');");
			    out.println("window.location.href='login.jsp';"); // Redirect to the login page
			    out.println("</script>");
			    out.println("</body></html>");
		}
		else {
			
			List<student> stDetails = studentDBUtil.getStudentDetails(id);
			request.setAttribute("stDetails", stDetails);
			
			// Display a JavaScript error message
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println("<html><body>");
		    out.println("<script type='text/javascript'>");
		    out.println("alert('Cannot delete user account.');");
		    out.println("window.location.href='studentprofile.jsp';"); // Redirect to the user profile page
		    out.println("</script>");
		    out.println("</body></html>");
		}
		
	}

}
