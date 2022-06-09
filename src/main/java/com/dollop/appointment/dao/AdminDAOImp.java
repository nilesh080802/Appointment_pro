package com.dollop.appointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dollop.appointment.model.AdminPatientData;
import com.dollop.appointment.utility.DBConnection;

public class AdminDAOImp {
	static Connection con=null;
	
	public AdminDAOImp() {
		con= DBConnection.openConnection();
	}
	
	public ArrayList<AdminPatientData> allPatientsData() {
		
		ArrayList<AdminPatientData> patientList = new ArrayList<>();
		String dql="Select * From patientprofilesetting";
		try {
			PreparedStatement ps = con.prepareStatement(dql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				AdminPatientData apd = new AdminPatientData();
				
				apd.setFirstName(rs.getString("firstName"));
				apd.setLastName(rs.getString("lastName"));
				//System.out.println(rs.getString("lastName")+"  "+rs.getString("firstName"));
				
				  apd.setAge(rs.getInt("Age"));
				  apd.setAddress(rs.getString("address"));
				  apd.setCity(rs.getString("city"));
				  apd.setState(rs.getString("state"));
				  apd.setZipCode(rs.getString("zipCode"));
				  apd.setCountry(rs.getString("country"));
				  apd.setMobile(rs.getString("mobile"));
				  
				  
				 
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
			// TODO: handle exception
		}
		
		
		return patientList;
	
	
	}
	
	//----------only one patient data------
	public  AdminPatientData patientData(String mobile) {
		
		String dql="Select * From patientprofilesetting where mobile=?";
		AdminPatientData apdu = new AdminPatientData();
		try {
			
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setString(1, mobile);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				apdu.setFirstName(rs.getString("firstName"));
				apdu.setLastName(rs.getString("lastName"));
				apdu.setBloodGroup(rs.getString("bloodGroup"));
				apdu.setAge(rs.getInt("Age"));
				apdu.setDateOfBirth(rs.getString("dateOfBirth"));
				apdu.setEmailId(rs.getString("emailId"));
				apdu.setMobile(rs.getString("mobile"));
				apdu.setAddress(rs.getString("address"));
				apdu.setCity(rs.getString("city"));
				apdu.setState(rs.getString("state"));
				apdu.setZipCode(rs.getString("zipCode"));
				apdu.setCountry(rs.getString("country"));
				}
				
				//========this is for upload photo in database
				/*
				Blob blob = rs.getBlob("photo");
				InputStream inputstream = null;
				if(blob!=null) {
			    inputstream = blob.getBinaryStream();
			    // read the input stream...		
				 
				}
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				 byte[] buffer = new byte[4096];
				 int bytesRead=-1;
				 
				 while((bytesRead = inputstream.read(buffer)) != -1) {
					 outputStream.write(buffer,0,bytesRead);
					 
				 }
				 byte[] imageBytes = outputStream.toByteArray();
				 String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				 
				 inputstream.close();
				 outputStream.close();
				 //-------here set the binary data of image
				 apdu.setBase64Image(base64Image);
//				 apdu.setPhoto( inputstream);<---it is not required here because we already set binary data
		 	}else {
			
				System.out.println("data is empty");
				
			}*/
			
		} catch (Exception e) {
			
			System.out.println(e);
			// TODO: handle exception
			
		}
		
		
		return apdu;
	
	
	}
	

	
	public boolean verifyUser(String mobileNumber, String password) {
		//this method for verify user . user is register or not
		System.out.println(mobileNumber+"  "+password);
		String dql = "select * from admindata where mobileNumber=? AND password=?";
		try {
			
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setString(1, mobileNumber);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				return true;
			}
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return false;
	}
	public boolean verifyPassword( String password) {
		//this method for verify admin ,admin is registerd or not
//		System.out.println(mobileNumber+"  "+password);
		String dql = "select * from admindata where  password=?";
		try {
			
			PreparedStatement ps = con.prepareStatement(dql);
			
			ps.setString(1, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				return true;
			}
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
