package com.dollop.appointment.dao;

//import java.io.ByteArrayOutputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dollop.appointment.model.PatientAppointmentShowData;
import com.dollop.appointment.model.PatientSettingData;

import com.dollop.appointment.utility.DBConnection;

public class PatientDAOImp {
static Connection con=null;
	
	public PatientDAOImp()
	{
		con=(Connection) DBConnection.openConnection();
		
	}
	 
	public ArrayList<PatientAppointmentShowData>  patientAppointmentGetData(String patientId) {
		
		String dql="Select * from appointmentdata where PatientId=?";
//		String dql2="select profileImage,firstName,lastName,speciality from doctorprofilesettingdata where doctorId=?";
		
		
		
		ArrayList<PatientAppointmentShowData> appointmentList= new ArrayList<PatientAppointmentShowData>();
		try {
			
			PreparedStatement ps = con.prepareStatement(dql);
//			PreparedStatement ps2 = con.prepareStatement(dql2);
			ps.setString(1, patientId);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				PatientAppointmentShowData pasd = new PatientAppointmentShowData();
				pasd.setDoctorId(rs.getString("DoctorId"));
				pasd.setPatientId(rs.getString("PatientId"));
				
				pasd.setApptDate(rs.getString("AppointmentDate"));
				pasd.setBookingDate(rs.getString("BookingDate"));
				pasd.setAmount(rs.getInt("Amount"));
				pasd.setStatus(rs.getInt("Status"));
				System.out.println(rs.getInt("Status")+"-dao");
				
				//----------------
				
				/*
				 * ps2.setString(1, rs.getString("DoctorId")); ResultSet rs1 =
				 * ps2.executeQuery(); rs1.next();
				 * pasd.setDoctorImage(rs1.getString("profileImage"));
				 * pasd.setdFirstName(rs1.getString("firstName"));
				 * pasd.setdLastName(rs1.getString("lastName"));
				 * pasd.setSpecialization(rs.getString("specialization"));
				 */
				
				appointmentList.add(pasd);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		return appointmentList;
		
		
	}
	
	public PatientSettingData patientProfileGetData(String mobileNumber) {
		
		String DQL ="select * from patientProfileSetting where mobile=?";
		
		PatientSettingData psd = new PatientSettingData();
		try {
		
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(DQL);
			ps.setString(1, mobileNumber);
			ResultSet rs = ps.executeQuery();
			

			
			if(rs.next()) {
				
				psd.setFirstName(rs.getString("firstName"));
				psd.setLastName(rs.getString("lastName"));
				psd.setBloodGroup(rs.getString("bloodGroup"));
//				psd.setAge(rs.getInt("Age"));
				psd.setDateOfBirth(rs.getString("dateOfBirth"));
				psd.setEmailId(rs.getString("emailId"));
				psd.setMobile(rs.getString("mobile"));
				psd.setAddress(rs.getString("address"));
				psd.setCity(rs.getString("city"));
				psd.setState(rs.getString("state"));
				psd.setZipCode(rs.getString("zipCode"));
				psd.setCountry(rs.getString("country"));
				psd.setImagePath(rs.getString("imagePath"));
				psd.setPatientId(rs.getString("PatientId"));
				
				System.out.println(mobileNumber+"-"+rs.getString("mobile")+"get->"+rs.getString("imagePath"));
				
				
		 	}else {
			
				System.out.println("data is empty");
				
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	
		return psd;
	}
	

	//method for inserting details of patient
//	@SuppressWarnings("resource")
	public void patientProfileInsData(PatientSettingData psd) { 
	  String DML="UPDATE patientProfileSetting SET firstName=?,lastName=?,bloodGroup=?,dateOfBirth=?,emailId=?,address=?,city=?,state=?,zipCode=?,country=?,imagePath=? WHERE mobile=?"; 
	  
	  try {
	  
	  PreparedStatement ps=(PreparedStatement) con.prepareStatement(DML);

	  
	  
	  System.out.println("img-path->"+psd.getImagePath());
	  
	  ps.setString(1,psd.getFirstName()); 
	  ps.setString(2,psd.getLastName());
	  ps.setString(3,psd.getBloodGroup());
//	  ps.setInt(4,psd.getAge());
	  ps.setString(4,psd.getDateOfBirth());
	  ps.setString(5,psd.getEmailId()); 
	  ps.setString(6,psd.getAddress());
	  ps.setString(7,psd.getCity());
	  ps.setString(8,psd.getState()); 
	  ps.setString(9,psd.getZipCode());
	  ps.setString(10,psd.getCountry());
	  ps.setString(11, psd.getImagePath());
	  ps.setString(12,psd.getMobile());
	  
	  
	  
	  ps.executeUpdate();
	  
	  }catch(Exception e) {
	  
	  e.printStackTrace();
	  
	  
	  }
	  
	   
	  
	 }
	  

}
