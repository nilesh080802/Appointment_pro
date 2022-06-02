package com.dollop.appointment.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dollop.appointment.model.PatientSettingData;
import com.dollop.appointment.utility.DBConnection;

public class PatientDAOImp {
static Connection con=null;
	
	public PatientDAOImp()
	{
		con=(Connection) DBConnection.openConnection();
		
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
				
				
				/*This is for image view on jsp
				 * Blob blob = rs.getBlob("photo"); InputStream inputstream = null;
				 * if(blob!=null) { inputstream = blob.getBinaryStream(); // read the input
				 * stream...
				 * 
				 * } ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); byte[]
				 * buffer = new byte[4096]; int bytesRead=-1;
				 * 
				 * while((bytesRead = inputstream.read(buffer)) != -1) {
				 * outputStream.write(buffer,0,bytesRead);
				 * 
				 * } byte[] imageBytes = outputStream.toByteArray(); String base64Image =
				 * Base64.getEncoder().encodeToString(imageBytes);
				 * 
				 * inputstream.close(); outputStream.close(); //-------here set the binary data
				 * of image psd.setBase64Image(base64Image);
				 */
//				 psd.setPhoto( inputstream);<---it is not required here because we already set binary data
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
	  String DML="UPDATE patientProfileSetting SET firstName=?,lastName=?,bloodGroup=?,dateOfBirth=?,emailId=?,address=?,city=?,state=?,zipCode=?,country=?,photo=? WHERE mobile=?"; 
	  
	  try {
	  
	  PreparedStatement ps=(PreparedStatement) con.prepareStatement(DML);

	  
	  
	  
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
	  
	  ps.setBlob(11, psd.getPhoto());
	  
	  ps.setString(12,psd.getMobile());
	  
	  
	  
	  ps.executeUpdate();
	  
	  }catch(Exception e) {
	  
	  e.printStackTrace();
	  
	  
	  }
	  
	   
	  
	 }
	  

}
