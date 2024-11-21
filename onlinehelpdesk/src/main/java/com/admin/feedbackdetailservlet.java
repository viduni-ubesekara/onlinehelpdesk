package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feedback.feedback;

import model.adminDBUtil;



/**
 * Servlet implementation class feedbackdetailservlet
 */
@WebServlet("/feedbackdetailservlet")
public class feedbackdetailservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			List<feedback> feedbackdetail = adminDBUtil.getfeedbackDetails();
			request.setAttribute("feedbackdetail", feedbackdetail);
		
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("feedback servlet is not connected!");
	}
		RequestDispatcher dis = request.getRequestDispatcher("allfeedbackdetails.jsp");
		dis.forward(request, response);
	}
	

}
