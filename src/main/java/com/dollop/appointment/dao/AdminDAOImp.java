package com.dollop.appointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dollop.appointment.model.AdminData;
import com.dollop.appointment.model.AdminRegistrationData;

import com.dollop.appointment.model.DoctorSettingData;
import com.dollop.appointment.model.PatientSettingData;
import com.dollop.appointment.utility.DBConnection;

public class AdminDAOImp {
	static Connection con=null;
	
	public AdminDAOImp() {
		con= DBConnection.openConnection();
	
		
	}
	
	public void insertAdminRegistrationData(AdminRegistrationData ad)
	{
		String DML="insert into admindata (firstName,lastName,email,mobileNumber,pass) values(?,?,?,?,?)";
		String DML1="insert into adminprofiledata (firstName,lastName,email,mobileNumber) values(?,?,?,?)";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(DML);
						
			ps.setString(1,ad.getFirstName());
			ps.setString(2,ad.getLastName());
			ps.setString(3,ad.getEmail());
			ps.setString(4,ad.getMobileNumber());
			ps.setString(5,ad.getPassword());
		
			
			ps.executeUpdate();
			
			PreparedStatement ps1 = con.prepareStatement(DML1);

		
			ps1.setString(1,ad.getFirstName());
			ps1.setString(2,ad.getLastName());
			ps1.setString(3,ad.getEmail());
			ps1.setString(4,ad.getMobileNumber());
		
			ps1.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
//	this method is for change the admin password
	
	public boolean changePassword(AdminRegistrationData ard,String pass)
	{
		String DQL="select pass from admindata where mobileNumber=?";
		
		
		try
		{
			
			if((ard.getPassword()).equals((ard.getConPassword())))
			{
				String pas=null;
				PreparedStatement ps=con.prepareStatement(DQL);
				
				ps.setString(1, ard.getMobileNumber() );
				
				
				ResultSet rs= ps.executeQuery();
				
//				System.out.println(rs.next());
				if(rs.next())
				{
					 pas=rs.getString("pass");
				
				}
				
				if(pas.equals(pass))
				{
					
					
					String DML="update admindata set pass=? where mobileNumber=?";
					
					PreparedStatement ps1=con.prepareStatement(DML);
					
					ps1.setString(1,ard.getPassword());
					ps1.setString(2, ard.getMobileNumber());
			
					
					ps1.executeUpdate();
					
					return true;
				}
				else {
					System.out.print("change Password fail");
				}
			}
			else
			{
				return false;
				
			}
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
//	this method is for edit the admin profile data
	
	public void editAdminProfileData(AdminData ad)
	{
		String DML="UPDATE adminprofiledata SET firstName=? ,lastName=? , dateOfBirth=? , email=? , address=? , city=? , state=? , zipCode=? , country=?  where mobileNumber=? ";
		String DML1="UPDATE admindata SET firstName=? ,lastName=? , email=? where mobileNumber=? ";
		
		try {
			
			PreparedStatement ps= con.prepareStatement(DML);
			PreparedStatement ps1= con.prepareStatement(DML1);
			
			ps.setString(1, ad.getFirstName());
			ps.setString(2,ad.getLastName());
			ps.setString(3, ad.getDateOfBirth());
			ps.setString(4, ad.getEmail());
			ps.setString(5, ad.getAddress());
			ps.setString(6, ad.getCity());
			ps.setString(7, ad.getState());
			ps.setString(8, ad.getZipCode());
			ps.setString(9, ad.getCountry());
			ps.setString(10, ad.getMobileNumber());
			
			ps.executeUpdate();
			
			ps1.setString(1, ad.getFirstName());
			ps1.setString(2,ad.getLastName());
			ps1.setString(3, ad.getEmail());
			ps1.setString(4, ad.getMobileNumber());
			
			ps1.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	//this method is for show Admin all data
	
	public AdminData getAdminData(String mobile)
	{
		 String DQL=" select * from adminprofiledata where mobileNumber = ?";
		 System.out.println(mobile);
		 
			AdminData ad=new AdminData();
		    try {
		    	PreparedStatement ps=con.prepareStatement(DQL);
		    	
		    	ps.setString(1,mobile);
		    	ResultSet rs=ps.executeQuery();
		    	
		    	if(rs.next())
		    	{
		    	
		    		
		    		
                    ad.setFirstName(rs.getString("firstName"));
                    System.out.println(rs.getString("firstName"));
		    		
		    		ad.setLastName(rs.getString("lastName")); 
		    		
		    		ad.setDateOfBirth(rs.getString("dateOfBirth"));
		    		
		    		ad.setEmail(rs.getString("email"));
		    		
		    		ad.setMobileNumber(rs.getString("mobileNumber")); 
		    		
		    		ad.setAddress(rs.getString("address")); 
		    		
		    		ad.setCity(rs.getString("city")); 
		    		
		    		ad.setState(rs.getString("state")); 
		    		
		    		ad.setZipCode(rs.getString("zipCode"));
		    		
		    		ad.setCountry(rs.getString("country"));
		    		
		    		
		    				
		    	}
		    	
		    	
		    	
		    }catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    return ad;
		
		
	}
	
	
	// this methos is for show all patient available in doctorprofilesetting table

	public ArrayList<PatientSettingData> allPatientsData() {
		
		ArrayList<PatientSettingData> patientList = new ArrayList<>();
		String dql="Select * From patientprofilesetting";
		try {
			PreparedStatement ps = con.prepareStatement(dql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				PatientSettingData apd = new PatientSettingData();
				
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
				  
				  patientList.add(apd);
				 
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
			// TODO: handle exception
		}
		
		return patientList;
	}
		
		// this methos is for show all doctor available in doctorprofilesetting table
		public ArrayList<DoctorSettingData> allDoctorsData() {
			
			ArrayList<DoctorSettingData> doctorList = new ArrayList<>();
			String dql="Select * From doctorprofilesetting";
			try {
				PreparedStatement ps = con.prepareStatement(dql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					DoctorSettingData apd = new DoctorSettingData();
					// doctor setting data required
					
					
					/*
					 * apd.setFirstName(rs.getString("firstName"));
					 * apd.setLastName(rs.getString("lastName"));
					 * //System.out.println(rs.getString("lastName")+"  "+rs.getString("firstName"))
					 * ;
					 * 
					 * apd.setAge(rs.getInt("Age")); apd.setAddress(rs.getString("address"));
					 * apd.setCity(rs.getString("city")); apd.setState(rs.getString("state"));
					 * apd.setZipCode(rs.getString("zipCode"));
					 * apd.setCountry(rs.getString("country"));
					 * apd.setMobile(rs.getString("mobile"));
					 */					 
				}
				
			} catch (Exception e) {
				
				System.out.println(e);
				// TODO: handle exception
			}

		
		 
		return doctorList;
	
	
	}
	
	//----------this method is only for getting one patient data------
	public  PatientSettingData patientData(String mobile) {
		
		String dql="Select * From patientprofilesetting where mobile=?";
		PatientSettingData apdu = new PatientSettingData();
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
				
			
		} catch (Exception e) {
			
			System.out.println(e);
			// TODO: handle exception
			
		}
		
		
		return apdu;
	
	
	}
	
	//----------this method is only for getting one doctor data------

public  DoctorSettingData doctorData(String mobile) {
		
		String dql="Select * From doctorprofilesetting where mobile=?";
		DoctorSettingData apdu = new DoctorSettingData();
		try {
			
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setString(1, mobile);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				// here we will write code for getting data which are come from the doctorprofilesetting 
				/*
				 * apdu.setFirstName(rs.getString("firstName"));
				 * apdu.setLastName(rs.getString("lastName"));
				 * apdu.setBloodGroup(rs.getString("bloodGroup"));
				 * apdu.setAge(rs.getInt("Age"));
				 * apdu.setDateOfBirth(rs.getString("dateOfBirth"));
				 * apdu.setEmailId(rs.getString("emailId"));
				 * apdu.setMobile(rs.getString("mobile"));
				 * apdu.setAddress(rs.getString("address")); apdu.setCity(rs.getString("city"));
				 * apdu.setState(rs.getString("state"));
				 * apdu.setZipCode(rs.getString("zipCode"));
				 * apdu.setCountry(rs.getString("country"));
				 */				}
				
			
		} catch (Exception e) {
			
			System.out.println(e);
			// TODO: handle exception
			
		}
		
		
		return apdu;
	
	
	}

 
	

	
	public boolean verifyUser(String mobileNumber, String password) {
		//this method for verify user . user is register or not
		System.out.println(mobileNumber+"  "+password);
		String dql = "select * from admindata where mobileNumber=? AND pass=?";
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
		String dql = "select * from admindata where  pass=?";
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
