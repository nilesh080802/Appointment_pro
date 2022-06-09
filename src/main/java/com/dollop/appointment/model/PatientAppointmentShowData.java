package com.dollop.appointment.model;

public class PatientAppointmentShowData {

	private String doctorImage;
	private String dFirstName;
	private String dLastName;
	private String specialization;
	
	private String doctorId;
	private String patientId;
	private String apptDate;
	private String bookingDate;
	private Integer Amount;
//	private String followUp;
	private int status;
	//-----------methods
	
	
	
		
	public String getdFirstName() {
		return dFirstName;
	}
	public String getDoctorImage() {
		return doctorImage;
	}
	public void setDoctorImage(String doctorImage) {
		this.doctorImage = doctorImage;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public void setdFirstName(String dFirstName) {
		this.dFirstName = dFirstName;
	}
	public String getdLastName() {
		return dLastName;
	}
	public void setdLastName(String dLastName) {
		this.dLastName = dLastName;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getApptDate() {
		return apptDate;
	}
	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Integer getAmount() {
		return Amount;
	}
	public void setAmount(Integer amount) {
		Amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
