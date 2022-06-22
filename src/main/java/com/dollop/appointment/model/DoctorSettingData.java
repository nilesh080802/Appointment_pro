package com.dollop.appointment.model;


import java.util.ArrayList;

public class DoctorSettingData 
{
	private int doctorId;

	private String firstName;
	private Integer  doctorId;
	private String lastName;
	private String mobileNumber;
	private String gender;
	private String dateOfBirth;
	private String biography;
	private String clinicName;
	private String clinicAddress;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private String pricing;
	private String services;
	private String specialist;
	private String imagePath;
	
	private ArrayList<Integer> degreeId;
	private ArrayList<String> degree;
	private ArrayList<String> college;
	private ArrayList<String> yearCompletetion;
	
	private ArrayList<Integer> hospitalId;
	private ArrayList<String> hospitalName;
	private ArrayList<String> from;
	private ArrayList<String> to;
	private ArrayList<String> designation;
	
	private ArrayList<Integer> awardId;
	private ArrayList<String> award;
	private ArrayList<String> awardYear;
	
	private ArrayList<Integer> membershipId;
	private ArrayList<String> memberships;
	
	private ArrayList<Integer> registrationId;
	private ArrayList<String> registration;
	private ArrayList<String> registrationYear;

	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	
	public ArrayList<Integer> getDegreeId()
	{
		return degreeId;
	}
	public void setDegreeId(ArrayList<Integer> degreeId)
	{
		this.degreeId= degreeId ;
	}
	
	public ArrayList<Integer> getHospitalId()
	{
		return hospitalId;
	}
	public void setHospitalId(ArrayList<Integer> hospitalId)
	{
		this.hospitalId = hospitalId;
	}
	
	public int getDoctorId()
	{
		return doctorId;
	}
	public void setDoctorId(int doctorId)
	{
		this.doctorId = doctorId;
	}

	public String getFirstName() {
	return firstName;
	}
	public void setFirstName(String firstName) {
	this.firstName = firstName;
//	System.out.println(this.firstName);
	}
	public String getLastName() {
	return lastName;
	}
	public void setLastName(String lastName) {
	this.lastName = lastName;
//	System.out.println(this.lastName);
	}
	public String getMobileNumber() {
	return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
//	System.out.println(this.mobileNumber);
	}
	public String getGender() {
	return gender;
	}
	public void setGender(String gender) {
	this.gender = gender;
//	System.out.println(this.gender);
	}
	public String getDateOfBirth() {
	return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
//	System.out.println(this.dateOfBirth);
	}
	public String getBiography() {
	return biography;
	}
	public void setBiography(String biography) {
	this.biography = biography;
//	System.out.println(this.biography);
	}
	public String getClinicName() {
	return clinicName;
	}
	public void setClinicName(String clinicName) {
	this.clinicName = clinicName;
//	System.out.println(this.clinicName);
	}
	public String getClinicAddress() {
	return clinicAddress;
	}
	public void setClinicAddress(String clinicAddress) {
	this.clinicAddress = clinicAddress;
//	System.out.println(this.clinicAddress);
	}
	public String getAddressLine1() {
	return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
//	System.out.println(this.addressLine1);
	}
	public String getAddressLine2() {
	return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
//	System.out.println(this.addressLine2);
	}
	public String getCity() {
	return city;
	}
	public void setCity(String city) {
	this.city = city;
//	System.out.println(this.city);
	}
	public String getState() {
	return state;
	}
	public void setState(String state) {
	this.state = state;
//	System.out.println(this.state);
	}
	public String getCountry() {
	return country;
	}
	public void setCountry(String country) {
	this.country = country;
//	System.out.println(this.country);
	}
	public String getPostalCode() {
	return postalCode;
	}
	public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
//	System.out.println(this.postalCode);
	}
	public String getPricing() {
	return pricing;
	}
	public void setPricing(String pricing) {
	this.pricing = pricing;
//	System.out.println(this.pricing);
	}
	public String getServices() {
	return services;
	}
	public void setServices(String services) {
	this.services = services;
//	System.out.println(this.services);
	}
	public String getSpecialist() {
	return specialist;
	}
	public void setSpecialist(String specialist) {
	this.specialist = specialist;
//	System.out.println(this.specialist);
	}
	
	public String getImagePath()
	{
		return imagePath;
	}
	public void setImagePath(String imagePath)
	{
		this.imagePath = imagePath;
	}
		
	public ArrayList<String> getDegree() 
	{
		return degree;
	}
	public void setDegree(ArrayList<String> degree) 
	{
		this.degree = degree;
	
//		System.out.println(this.degree[0]);
//		System.out.println(this.degree[1]);
	}
	
	public ArrayList<String> getCollege() 
	{
		return college;
	}
	
	public void setCollege(ArrayList<String> college) 
	{
		this.college = college;
//		System.out.println(this.college[0]);
//		System.out.println(this.college[1]);
	}
	
	public ArrayList<String> getYearCompletetion() 
	{
	
		return yearCompletetion;
	}
	public void setYearCompletetion(ArrayList<String> yearCompletetion) 
	{
		this.yearCompletetion = yearCompletetion;
//		System.out.println(this.yearCompletetion[0]);
//		System.out.println(this.yearCompletetion[1]);
	}
	
	
	public ArrayList<String> getHospitalName() 
	{
		return hospitalName;
	}
	public void setHospitalName(ArrayList<String> hospitalName) 
	{
		this.hospitalName = hospitalName;
//		System.out.println(this.hospitalName[0]);
//		System.out.println(this.hospitalName[1]);
	}
	
	public ArrayList<String> getFrom() 
	{
		return from;
	}
	public void setFrom(ArrayList<String> from) 
	{
		this.from = from;
	}
	
	public ArrayList<String> getTo() 
	{
		return to;
	}
	public void setTo(ArrayList<String> to)
	{
		this.to = to;
	}
	
	public ArrayList<String> getDesignation() 
	{
		return designation;
	}
	public void setDesignation(ArrayList<String> designation) 
	{
		this.designation = designation;
	}
	
	public ArrayList<Integer> getAwardId()
	{
		return awardId;
	}
	public void setAwardId(ArrayList<Integer> awardId)
	{
		this.awardId = awardId;
	}
	
	public ArrayList<String> getAward() 
	{
		return award;
	}
	public void setAward(ArrayList<String> award) 
	{
		this.award = award;
	}
	public ArrayList<String> getAwardYear() 
	{
		return awardYear;
	}
	public void setAwardYear(ArrayList<String> awardYear) 
	{
		this.awardYear = awardYear;
	}
	
	public ArrayList<Integer> getMembershipId()
	{
		return membershipId;
	}
	public void setMembershipId(ArrayList<Integer> membershipId)
	{
		this.membershipId = membershipId;
	}
	
	public ArrayList<String> getMemberships() 
	{
		return memberships;
	}
	public void setMemberships(ArrayList<String> memberships) 
	{
		this.memberships = memberships;
	}
	
	public ArrayList<Integer> getRegistartionId()
	{
		return registrationId;
	}
	public void setRegistrationId(ArrayList<Integer> registrationId)
	{
		this.registrationId = registrationId;
	}
	
	public ArrayList<String> getRegistration() 
	{
		return registration;
	}
	public void setRegistration(ArrayList<String> registration) 
	{
		this.registration = registration;
	}
	
	public ArrayList<String> getRegistrationYear() 
	{
		return registrationYear;
	}
	public void setRegistrationYear(ArrayList<String> registrationYear) 
	{
		this.registrationYear = registrationYear;
	}	
}
