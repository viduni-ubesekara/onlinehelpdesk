package com.admin;

public class admin {

	private int adminid;
	private String name;
	private String admintype;
	private String email;
	private String phone;
	private String username;
	private String password;
	/**
	 * @param adminid
	 * @param name
	 * @param admintype
	 * @param email
	 * @param phone
	 * @param username
	 * @param password
	 */
	public admin(int adminid, String name, String admintype, String email, String phone, String username,
			String password) {
		super();
		this.adminid = adminid;
		this.name = name;
		this.admintype = admintype;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}
	public int getAdminid() {
		return adminid;
	}
	public String getName() {
		return name;
	}
	public String getAdmintype() {
		return admintype;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	
	
}
