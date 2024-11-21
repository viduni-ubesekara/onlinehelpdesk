package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.adminDBUtil;


/**
 * Servlet implementation class adminupdateservlet
 */
@WebServlet("/adminupdateservlet")
public class adminupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		//save the details that entered by student
		 String adminid = request.getParameter("adminid");//id is the parameter name of ID in studentprofile page inside url tag
			String name = request.getParameter("name");
			String admintype = request.getParameter("admintype");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = adminDBUtil.updateadmin(adminid,name,admintype,email,phone,username,password);//parameters used in updatestudent method in studentDBUtil class
		
		 if (isTrue) {
	            List<admin> adminDetails = adminDBUtil.getAdminDetails(adminid);
	            request.setAttribute("adminDetails", adminDetails);
	            // JavaScript message for success
	            out.println("<script>alert('Update successful!');</script>");
	            // Include the JSP page with the message
	            RequestDispatcher dis = request.getRequestDispatcher("adminprofile.jsp");
	            dis.include(request, response);
	        } else {
	        	 List<admin> adminDetails = adminDBUtil.getAdminDetails(adminid);
		            request.setAttribute("adminDetails", adminDetails);
	            // JavaScript message for failure
	            out.println("<script>alert('Update unsuccessful. Please try again.');</script>");
	            // Forward to userprofile.jsp for an unsuccessful update
	            RequestDispatcher dis = request.getRequestDispatcher("adminprofile.jsp");
	            dis.forward(request, response);
	        }
	}

}
