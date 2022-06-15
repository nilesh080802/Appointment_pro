package com.dollop.appointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.dollop.appointment.model.DoctorSettingData;
import com.dollop.appointment.utility.DBConnection;

public class DoctorDAOImp {

static Connection con=null;

	public DoctorDAOImp()
	{
		con=(Connection) DBConnection.openConnection();
	}

	public DoctorSettingData getDoctor(String mobileNumber,int doctorId)
	{
		String dql ="SELECT * FROM doctorprofilesetting Where mobileNumber = ?"; 
		DoctorSettingData doctor = new DoctorSettingData();
		try
		{
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setString(1, mobileNumber);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				doctor.setDoctorId(rs.getInt("doctorId"));
				doctor.setFirstName(rs.getString("firstName"));
				doctor.setLastName(rs.getString("lastName"));
				doctor.setMobileNumber(rs.getString("mobileNumber"));
				doctor.setGender(rs.getString("gender"));
				doctor.setDateOfBirth(rs.getString("dateOfBirth"));
				doctor.setBiography(rs.getString("biography"));
				doctor.setClinicName(rs.getString("clinicName"));
				doctor.setClinicAddress(rs.getString("clinicAddress"));
				doctor.setAddressLine1(rs.getString("addressLine1"));
				doctor.setAddressLine2(rs.getString("addressLine2"));
				doctor.setCity(rs.getString("city"));
				doctor.setState(rs.getString("state"));
				doctor.setCountry(rs.getString("country"));
				doctor.setPostalCode(rs.getString("postalCode"));
				doctor.setPricing(rs.getString("pricing"));
				doctor.setServices(rs.getString("services"));
				doctor.setSpecialist(rs.getString("specialist"));
			}
			doctor = getEducationDetails(doctorId,doctor);
			doctor = getDoctorExperienceDetails(doctorId, doctor);
			doctor = getDoctorAwardDetails(doctorId,doctor);
			doctor = getDoctorMembershipDetails(doctorId, doctor);
			doctor = getDoctorRegistrationDetails(doctorId, doctor);
			System.out.println("Return");
			return doctor;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return doctor;
	}
//-----------------------------------------------------------------------------------------------
		
	public DoctorSettingData getEducationDetails(int doctorId,DoctorSettingData doctor)
	{
		String dql = "SELECT * FROM doctoreducation WHERE doctorId = ?";
		try
		{
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setInt(1, doctorId);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Integer> degreeId = new ArrayList<Integer>();
			ArrayList<String> degree = new ArrayList<String>();
			ArrayList<String> college = new ArrayList<String>();
			ArrayList<String> yearCompletetion = new ArrayList<String>();
			
			while(rs.next())
			{
				degreeId.add(rs.getInt("degreeId"));
				degree.add(rs.getString("degree"));
				college.add(rs.getString("collage"));
				yearCompletetion.add(rs.getString("yearCompletetion"));
			}
			doctor.setDegreeId(degreeId);
			doctor.setDegree(degree);
			doctor.setCollege(college);
			doctor.setYearCompletetion(yearCompletetion);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return doctor;
	}

	public DoctorSettingData getDoctorExperienceDetails(int doctorId,DoctorSettingData doctor)
	{
		String dql = "SELECT * FROM doctorexperience WHERE doctorId = ?";
		try
		{
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setInt(1, doctorId);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Integer> hospitalId = new ArrayList<Integer>();
			ArrayList<String> hospitalName = new ArrayList<String>();
			ArrayList<String> fromYear = new ArrayList<String>();
			ArrayList<String> toYear = new ArrayList<String>();
			ArrayList<String> designation = new ArrayList<String>();
			while(rs.next())
			{
				hospitalId.add(rs.getInt("doctorId"));
				hospitalName.add(rs.getString("hospitalName"));
				fromYear.add(rs.getString("fromYear"));
				toYear.add(rs.getString("toYear"));
				designation.add(rs.getString("designation"));
			}
			doctor.setHospitalId(hospitalId);
			doctor.setHospitalName(hospitalName);
			doctor.setFrom(fromYear);
			doctor.setTo(toYear);
			doctor.setDesignation(designation);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return doctor;
	}
	
	public DoctorSettingData getDoctorAwardDetails(int doctorId,DoctorSettingData doctor)
	{
		String dql = "SELECT * FROM doctoraward WHERE doctorId = ?";
		try
		{
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setInt(1, doctorId);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Integer> awardId = new ArrayList<Integer>();
			ArrayList<String> awardName = new ArrayList<String>();
			ArrayList<String> awardYear = new ArrayList<String>();
			
			while(rs.next())
			{
				awardId.add(rs.getInt("awardId"));
				awardName.add(rs.getString("award"));
				awardYear.add(rs.getString("awardYear"));
			}
			doctor.setAwardId(awardId);
			doctor.setAward(awardName);
			doctor.setAwardYear(awardYear);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return doctor;
	}

	public DoctorSettingData getDoctorMembershipDetails(int doctorId,DoctorSettingData doctor)
	{
		String dql = "SELECT * FROM doctormemberships WHERE doctorId = ?";
		try
		{
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setInt(1, doctorId);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Integer> membershipId = new ArrayList<Integer>();
			ArrayList<String> membershipName = new ArrayList<String>();
			
			while(rs.next())
			{
				membershipId.add(rs.getInt("membershipId"));
				membershipName.add(rs.getString("membership"));
			}
			doctor.setMembershipId(membershipId);
			doctor.setMemberships(membershipName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return doctor;
	}
	
	public DoctorSettingData getDoctorRegistrationDetails(int doctorId,DoctorSettingData doctor)
	{
		String dql = "SELECT * FROM doctorregistrations WHERE doctorId = ?";
		try
		{
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setInt(1, doctorId);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Integer> registrationId = new ArrayList<Integer>();
			ArrayList<String> registrationName = new ArrayList<String>();
			ArrayList<String> registrationYear = new ArrayList<String>();
			while(rs.next())
			{
				registrationId.add(rs.getInt("registrationId"));
				registrationName.add(rs.getString("registration"));
				registrationYear.add(rs.getString("year"));
			}
			doctor.setRegistrationId(registrationId);
			doctor.setRegistration(registrationName);
			doctor.setRegistrationYear(registrationYear);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return doctor;
	}
//---------------------------------------------------------------------------------------------------------------------
	
	public boolean doctorProfileInsData(DoctorSettingData dsd,int doctorId)
	{
		boolean b1 = insertBasicInformation(dsd,doctorId);		
		boolean b2 = insertEducationDetails(dsd,doctorId);		
		boolean b3 = insertDoctorExperience(dsd, doctorId);
		boolean b4 = insertDoctorAwards(dsd, doctorId);
		boolean b5 = insertDoctorMembership(dsd, doctorId);
		boolean b6 = insertDoctorRegistration(dsd, doctorId);
		
		if(b1 == true && b2 == true)
		{
			System.out.println("Data Insert Succesfully");
			return true;
		}
		else
		{			
			System.out.println("Data Insertion Failed");
			return false;
		}
	}
	
	public boolean insertBasicInformation(DoctorSettingData dsd,int doctorId)
	{
		String dml = "UPDATE doctorprofilesetting SET firstName=?,lastName=?,mobileNumber=?,gender=?,dateOfBirth=?,biography=?,clinicName=?,clinicAddress=?,addressLine1=?,addressLine2=?,city=?,state=?,country=?,postalCode=?,pricing=?,services=?,specialist=?,imagePath=? WHERE doctorId=?";
		try
		{
			PreparedStatement ps= (PreparedStatement) con.prepareStatement(dml);
			
			ps.setString(1, dsd.getFirstName());
			ps.setString(2, dsd.getLastName());
			ps.setString(3, dsd.getMobileNumber());
			ps.setString(4, dsd.getGender());
			ps.setString(5, dsd.getDateOfBirth());
			ps.setString(6, dsd.getBiography());
			ps.setString(7, dsd.getClinicName());
			ps.setString(8, dsd.getClinicAddress());
			ps.setString(9, dsd.getAddressLine1());
			ps.setString(10, dsd.getAddressLine2());
			ps.setString(11, dsd.getCity());
			ps.setString(12, dsd.getState());
			ps.setString(13, dsd.getCountry());
			ps.setString(14, dsd.getPostalCode());
			ps.setString(15, dsd.getPricing());
			ps.setString(16, dsd.getServices());
			ps.setString(17, dsd.getSpecialist());
			ps.setString(18, dsd.getImagePath());
			
			ps.setInt(19, doctorId);
			int rowCount = ps.executeUpdate();
//			System.out.println(rowCount);
			if(rowCount == 1)
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insertEducationDetails(DoctorSettingData dsd, int doctorId)
	{
		String dml = null;	
		int rowCount = 0;
		ArrayList<Integer> degreeId = dsd.getDegreeId();
		ArrayList<String> degree = dsd.getDegree();
		ArrayList<String> college = dsd.getCollege();
		ArrayList<String> yearCompletetion = dsd.getYearCompletetion();
			
		for(int i=0;i<degree.size();i++)
		{	
			if(degreeId.size() == degree.size())
			{
			 	if(isDoctorDetailsExist("doctoreducation",doctorId,"degreeId",degreeId.get(i)))
				{	
//			 		System.out.println("Inside Condition True");
					dml = "UPDATE doctorEducation SET degree= ?,collage=?,yearCompletetion=? WHERE doctorId=? AND degreeId =?";
					try
					{
						PreparedStatement ps = con.prepareStatement(dml);
						ps.setString(1,degree.get(i));
						ps.setString(2,college.get(i));
						ps.setString(3, yearCompletetion.get(i));
						ps.setInt(4, doctorId);
						ps.setInt(5, degreeId.get(i));
						rowCount = ps.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}	
				}	
			}	
			else
			{
				dml = "INSERT INTO doctorEducation(degree,collage,yearCompletetion,doctorId) VALUES(?,?,?,?)";
				try
				{
					PreparedStatement ps = con.prepareStatement(dml);
					ps.setString(1, degree.get(i));
					ps.setString(2, college.get(i));
					ps.setString(3, yearCompletetion.get(i));
					ps.setInt(4, doctorId);
					rowCount = ps.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}					
			}					
		}		
		if(rowCount>0)
			return true;
		else
			return false;
	}
	
	public boolean insertDoctorExperience(DoctorSettingData dsd, int doctorId)
	{
		String dml = null;	
		int rowCount = 0;
		ArrayList<Integer> hospitalId = dsd.getHospitalId();
		ArrayList<String> hospitalName = dsd.getHospitalName();
		ArrayList<String> fromYear = dsd.getFrom();
		ArrayList<String> toYear = dsd.getTo();
		ArrayList<String> designation = dsd.getDesignation();
		
		if(hospitalName != null && fromYear != null && toYear != null && designation != null)
		{
			for(int i=0;i<hospitalName.size();i++)
			{	
				if(hospitalId.size() == hospitalName.size())
				{
				 	if(isDoctorDetailsExist("doctorexperience",doctorId,"hospitalId",hospitalId.get(i)))
					{	
				 		System.out.println("Inside Condition True");
						dml = "UPDATE doctorexperience SET hospitalName= ?,fromYear=?,toYear=?,designation=? WHERE doctorId=? AND hospitalId =?";
						try
						{
							PreparedStatement ps = con.prepareStatement(dml);
							ps.setString(1,hospitalName.get(i));
							ps.setString(2,fromYear.get(i));
							ps.setString(3, toYear.get(i));
							ps.setString(4, designation.get(i));
							ps.setInt(5, doctorId);
							ps.setInt(6, hospitalId.get(i));
							
							rowCount = ps.executeUpdate();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}	
					}	
				}	
				else
				{
					dml = "INSERT INTO doctorexperience(hospitalName,fromYear,toYear,designation,doctorId) VALUES(?,?,?,?,?)";
					try
					{
						PreparedStatement ps = con.prepareStatement(dml);
						ps.setString(1, hospitalName.get(i));
						ps.setString(2, fromYear.get(i));
						ps.setString(3, toYear.get(i));
						ps.setString(4, designation.get(i));
						ps.setInt(5, doctorId);
						
						rowCount = ps.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}					
				}					
			}		
			if(rowCount>0)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean insertDoctorAwards(DoctorSettingData dsd, int doctorId)
	{
		String dml = null;	
		int rowCount = 0;
		ArrayList<Integer> awardId = dsd.getAwardId();
		ArrayList<String> awardName = dsd.getAward();
		ArrayList<String> awardYear = dsd.getAwardYear();
		
		if(awardName != null && awardYear != null)
		{
			for(int i=0;i<awardName.size();i++)
			{	
				if(awardId.size() == awardName.size())
				{
				 	if(isDoctorDetailsExist("doctoraward",doctorId,"awardId",awardId.get(i)))
					{	
				 		System.out.println("Inside Condition True");
						dml = "UPDATE doctoraward SET award= ?,awardYear=?,WHERE doctorId=? AND awardId =?";
						try
						{
							PreparedStatement ps = con.prepareStatement(dml);
							ps.setString(1,awardName.get(i));
							ps.setString(2,awardYear.get(i));
							ps.setInt(3, doctorId);
							ps.setInt(4, awardId.get(i));
							
							rowCount = ps.executeUpdate();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}	
					}	
				}	
				else
				{
					dml = "INSERT INTO doctoraward(award,awardYear,doctorId) VALUES(?,?,?)";
					try
					{
						PreparedStatement ps = con.prepareStatement(dml);
						ps.setString(1, awardName.get(i));
						ps.setString(2, awardYear.get(i));
						ps.setInt(3, doctorId);
						
						rowCount = ps.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}					
				}					
			}		
			if(rowCount>0)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean insertDoctorMembership(DoctorSettingData dsd, int doctorId)
	{
		String dml = null;	
		int rowCount = 0;
		ArrayList<Integer> membershipId = dsd.getAwardId();
		ArrayList<String> membershipName = dsd.getAward();
		
		if(membershipName != null)
		{
			for(int i=0;i<membershipName.size();i++)
			{	
				if(membershipId.size() == membershipName.size())
				{
				 	if(isDoctorDetailsExist("doctormemberships",doctorId,"membershipId",membershipId.get(i)))
					{	
				 		System.out.println("Inside Condition True");
						dml = "UPDATE doctormemberships SET membership=?WHERE doctorId=? AND membershipId=?";
						try
						{
							PreparedStatement ps = con.prepareStatement(dml);
							ps.setString(1,membershipName.get(i));
							ps.setInt(2, doctorId);
							ps.setInt(3, membershipId.get(i));
							
							rowCount = ps.executeUpdate();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}	
					}	
				}	
				else
				{
					dml = "INSERT INTO doctormemberships(membership,doctorId) VALUES(?,?)";
					try
					{
						PreparedStatement ps = con.prepareStatement(dml);
						ps.setString(1, membershipName.get(i));
						ps.setInt(2, doctorId);
						
						rowCount = ps.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}					
				}					
			}		
			if(rowCount>0)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean insertDoctorRegistration(DoctorSettingData dsd, int doctorId)
	{
		String dml = null;	
		int rowCount = 0;
		ArrayList<Integer> registrationId = dsd.getRegistartionId();
		ArrayList<String> registration = dsd.getRegistration();
		ArrayList<String> registrationYear = dsd.getRegistrationYear();
		
		if(registration != null && registrationYear != null)
		{
			for(int i=0;i<registration.size();i++)
			{	
				if(registrationId.size() == registration.size())
				{
				 	if(isDoctorDetailsExist("doctorregistrations",doctorId,"membershipId",registrationId.get(i)))
					{	
//				 		System.out.println("Inside Condition True");
						dml = "UPDATE doctorregistrations SET registration,year=? WHERE doctorId=? AND registrationId=?";
						try
						{
							PreparedStatement ps = con.prepareStatement(dml);
							ps.setString(1,registration.get(i));
							ps.setString(2, registrationYear.get(i));
							ps.setInt(3, doctorId);
							ps.setInt(4, registrationId.get(i));
							
							rowCount = ps.executeUpdate();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}	
					}	
				}	
				else
				{
					dml = "INSERT INTO doctorregistrations(registrations,year,doctorId) VALUES(?,?,?)";
					try
					{
						PreparedStatement ps = con.prepareStatement(dml);
						ps.setString(1, registration.get(i));
						ps.setString(i,registrationYear.get(i));
						ps.setInt(3, doctorId);
						
						rowCount = ps.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}					
				}					
			}		
			if(rowCount>0)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean isDoctorDetailsExist(String tableName,int doctorId,String tableIdName,int tableId)
	{
		String dql = "SELECT * FROM "+tableName+" WHERE doctorId = ? AND "+tableIdName+" = ?";
		System.out.println("String : "+dql);
		try
		{
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setInt(1, doctorId);
			ps.setInt(2, tableId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
