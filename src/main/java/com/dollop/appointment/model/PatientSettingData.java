package com.dollop.appointment.model;

import java.io.InputStream;

public class PatientSettingData {
	
    private Integer patientId;
	private String firstName;
	private String lastName;
	private String bloodGroup;
	private Integer age;
	private String dateOfBirth;
	private String emailId;
	private String mobile;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	
	
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	private InputStream photo;
	private String base64Image;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public InputStream getPhoto() {
		
		return photo;
	}
	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}
	
//The field�s getter getBase64Image() will be called by a JSTL tag in the JSP page in order to show the image.
	public String getBase64Image() {
        return base64Image;
	}
	
//The field�s setter setBase64Image() will be called by a DAO class that retrieves the image binary data and converts it to a base64 string.

	 
	public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
	}


}
