package com.ticketraise;

public class ticketraise {
	
	
	private int ticketid;
	private String name;
	private String email;
	private String studentid;
	private String faculty;
	private String phone;
	private String inquiry;
	private String subinquiry;
	private String subject;
	private String message;
	/**
	 * @param ticketid
	 * @param name
	 * @param email
	 * @param studentid
	 * @param faculty
	 * @param phone
	 * @param inquiry
	 * @param subinquiry
	 * @param subject
	 * @param message
	 */
	public ticketraise(int ticketid, String name, String email, String studentid, String faculty, String phone,
			String inquiry, String subinquiry, String subject, String message) {
		super();
		this.ticketid = ticketid;
		this.name = name;
		this.email = email;
		this.studentid = studentid;
		this.faculty = faculty;
		this.phone = phone;
		this.inquiry = inquiry;
		this.subinquiry = subinquiry;
		this.subject = subject;
		this.message = message;
	}
	public int getTicketid() {
		return ticketid;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getStudentid() {
		return studentid;
	}
	public String getFaculty() {
		return faculty;
	}
	public String getPhone() {
		return phone;
	}
	public String getInquiry() {
		return inquiry;
	}
	public String getSubinquiry() {
		return subinquiry;
	}
	public String getSubject() {
		return subject;
	}
	public String getMessage() {
		return message;
	}
	
	
	

}
