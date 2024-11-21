package com.student;

public class student {
	
	private int id;
	private String studentid;
	private String name;
	private String nic;
	private String dob;
	private String email;
	private String phone;
	private String faculty;
	private String address;
	private String username;
	private String password;
	/**
	 * @param id
	 * @param studentid
	 * @param name
	 * @param nic
	 * @param dob
	 * @param email
	 * @param phone
	 * @param faculty
	 * @param address
	 * @param username
	 * @param password
	 */
	public student(int id, String studentid, String name, String nic, String dob, String email, String phone,
			String faculty, String address, String username, String password) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.name = name;
		this.nic = nic;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.faculty = faculty;
		this.address = address;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public String getStudentid() {
		return studentid;
	}
	public String getName() {
		return name;
	}
	public String getNic() {
		return nic;
	}
	public String getDob() {
		return dob;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getFaculty() {
		return faculty;
	}
	public String getAddress() {
		return address;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	
	
	
	
	
}