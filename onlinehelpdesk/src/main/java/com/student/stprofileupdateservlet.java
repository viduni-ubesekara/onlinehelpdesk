package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.studentDBUtil;



/**
 * Servlet implementation class stprofileupdateservlet
 */
@WebServlet("/stprofileupdateservlet")
public class stprofileupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		//save the details that entered by student
		String id = request.getParameter("id");//id is the parameter name of ID in studentprofile page inside url tag
		String studentid = request.getParameter("studentid");
		String name = request.getParameter("name");
		String nic = request.getParameter("nic");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String faculty = request.getParameter("faculty");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = studentDBUtil.updatestudent(id,studentid,name,nic,dob,email,phone,faculty,address,username,password);//parameters used in updatestudent method in studentDBUtil class
		
		 if (isTrue) {
	            List<student> stDetails = studentDBUtil.getStudentDetails(id);
	            request.setAttribute("stDetails", stDetails);
	            // JavaScript message for success
	            out.println("<script>alert('Update successful!');</script>");
	            // Include the JSP page with the message
	            RequestDispatcher dis = request.getRequestDispatcher("studentprofile.jsp");
	            dis.include(request, response);
	        } else {
	            List<student> stDetails = studentDBUtil.getStudentDetails(id);
	            request.setAttribute("stDetails", stDetails);
	            // JavaScript message for failure
	            out.println("<script>alert('Update unsuccessful. Please try again.');</script>");
	            // Forward to userprofile.jsp for an unsuccessful update
	            RequestDispatcher dis = request.getRequestDispatcher("userprofile.jsp");
	            dis.forward(request, response);
	        }
	}

}
