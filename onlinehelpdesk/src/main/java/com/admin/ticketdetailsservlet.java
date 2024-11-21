package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ticketraise.ticketraise;

import model.adminDBUtil;

/**
 * Servlet implementation class ticketdetailsservlet
 */
@WebServlet("/ticketdetailsservlet")
public class ticketdetailsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			List<ticketraise> ticketdetail = adminDBUtil.getticketDetails();
			request.setAttribute("ticketdetail", ticketdetail);
		
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("ticket servlet is not connected!");
	}
		RequestDispatcher dis = request.getRequestDispatcher("allticketdetails.jsp");
		dis.forward(request, response);
	}
	

}
