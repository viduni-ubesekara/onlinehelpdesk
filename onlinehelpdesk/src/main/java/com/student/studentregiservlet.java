package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.studentDBUtil;



/**
 * Servlet implementation class studentregiservlet
 */
@WebServlet("/studentregiservlet")
public class studentregiservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		    
		
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
		
		boolean isTrue;//catch the return value by the variable
		
		isTrue = studentDBUtil.insertstudent(studentid,name,nic,dob,email,phone,faculty,address,username,password);
		
		if(isTrue == true) {//check the database connection success or not
			 out.println("<script type=\"text/javascript\">");
			    out.println("alert('Student account registered successfully!');");
			    out.println("window.location.href = 'login.jsp';"); // Redirect to your registration page
			    out.println("</script>");
		} else {
		    // Replace the RequestDispatcher with a JavaScript alert
		   
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Student account not registered successfully!');");
		    out.println("window.location.href = 'studentregi.jsp';"); // Redirect to your registration page
		    out.println("</script>");
		}
	}

}
