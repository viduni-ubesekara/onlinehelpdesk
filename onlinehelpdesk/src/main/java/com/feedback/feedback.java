package com.feedback;

public class feedback {
	
	private int feedbackid;
	private String name;
	private String email;
	private String studentid;
	private String faculty;
	private String phone;
	private String message;
	private String rating;
	/**
	 * @param feedbackid
	 * @param name
	 * @param email
	 * @param studentid
	 * @param faculty
	 * @param phone
	 * @param message
	 * @param rating
	 */
	public feedback(int feedbackid, String name, String email, String studentid, String faculty, String phone,
			String message, String rating) {
		super();
		this.feedbackid = feedbackid;
		this.name = name;
		this.email = email;
		this.studentid = studentid;
		this.faculty = faculty;
		this.phone = phone;
		this.message = message;
		this.rating = rating;
	}
	public int getFeedbackid() {
		return feedbackid;
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
	public String getMessage() {
		return message;
	}
	public String getRating() {
		return rating;
	}
	
	
	
	
	
	

}
