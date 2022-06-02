package com.dollop.appointment.model;

public class UserData {
	
	private String fname;
	private String lname;
	private String mobileNumber;
	private String password;
	private Integer type;
	//-----------Setter and getter methods for user data----------------//
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Integer getType() {
		
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
