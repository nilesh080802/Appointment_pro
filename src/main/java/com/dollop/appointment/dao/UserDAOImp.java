package com.dollop.appointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dollop.appointment.model.UserData;
import com.dollop.appointment.utility.DBConnection;

public class UserDAOImp 
{
	static Connection con=null;

	public UserDAOImp() {
		
		
		con= DBConnection.openConnection();
	}
	
	public void generatePatientId(String mobile)
	{
		String dql="SELECT pid FROM `patientprofilesetting` WHERE mobile=?";
		String dml="Update patientprofilesetting SET PatientId=? where mobile=?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setString(1, mobile);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			int pid=rs.getInt("pid");
			
			String patientId = "PT0"+pid;
			PreparedStatement ps2 = con.prepareStatement(dml);
			ps2.setString(1, patientId);
			ps2.setString(2, mobile);
			ps2.executeUpdate();
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void	addUserData(UserData ud)  {
		//this method for add user into database
		String dml="insert into userdata(firstName,lastName,mobileNumber,password,type) values(?,?,?,?,?)";
		

		
	public void	addUserData(UserData ud)  
	{
		//this method for add user into database
		String dml="insert into userdata values(?,?,?,?,?)";		
		try 
		{			
			PreparedStatement ps = con.prepareStatement(dml);
			ps.setString(1,ud.getFname());
			ps.setString(2,ud.getLname());
			ps.setString(3, ud.getMobileNumber());
			ps.setString(4, ud.getPassword());
			ps.setInt(5, ud.getType());
			
			ps.executeUpdate();
		
			if(ud.getType()==0) 
			{
				String dmlpps="insert into patientprofilesetting(firstName,lastName,mobile) values(?,?,?)";
				PreparedStatement ps2 = con.prepareStatement(dmlpps);
				ps2.setString(1,ud.getFname());
				ps2.setString(2,ud.getLname());
				ps2.setString(3, ud.getMobileNumber());
			
				ps2.executeUpdate();
				
				generatePatientId(ud.getMobileNumber());
				
				
			}

			else
			{
				String dmldps = "INSERT INTO doctorprofilesetting(firstName,lastName,mobileNumber) VALUES(?,?,?)";				
				PreparedStatement ps3 =  con.prepareStatement(dmldps);
				ps3.setString(1, ud.getFname());
				ps3.setString(2, ud.getLname());
				ps3.setString(3, ud.getMobileNumber());
				
				ps3.executeUpdate();
				addAllTable(ud.getMobileNumber());				
			}			
		} 
		catch(Exception e) 
		{			

			
			
		} catch (Exception e) {
			

			e.printStackTrace();
		}		
	}
	
	public boolean identifyUser(String mobileNumber) 
	{		
		//This method for identify user ->is user doctor or patient
		String dql = "select type from userdata where mobileNumber=?";
		try 
		{			
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setString(1, mobileNumber);
			 
			ResultSet rs = ps.executeQuery();
					
			rs.next();
		
			int type= rs.getInt("type");
			
			if(type==1) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return false;
		
	}


	public boolean verifyUser(String mobileNumber, String password) {
		//this method for verify user . user is register or not
		//System.out.println(mobileNumber+"  "+password);
		String dql = "select * from userdata where mobileNumber=? AND password=?";
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
		//this method for verify user . user is registerd or not
//		System.out.println(mobileNumber+"  "+password);
		String dql ="select * from userdata where password=?";
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
	

	public Integer getPatientId(String mobileNumber) {
		
		String dql="select patientId from patientprofilesetting where mobile=?";
		Integer id=null;
		
        try {
			
			PreparedStatement ps = con.prepareStatement(dql);		
			ps.setString(1, mobileNumber);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			id=	rs.getInt("patientId"); 
			}
						
		} 
        catch (Exception e) {
			// TODO: handle exception
		}
		return id;
	}


	public void addAllTable(String mobileNumber)
	{
		String dql = "SELECT * FROM doctorprofilesetting WHERE mobileNumber=?";
		int doctorId = 0;
		try
		{
			PreparedStatement ps = con.prepareStatement(dql);
			ps.setString(1, mobileNumber);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				doctorId = rs.getInt("doctorId");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String docDml = "INSERT INTO doctoreducation(doctorId) VALUES(?);INSERT INTO doctorexperience(doctorId) VALUES(?);INSERT INTO doctoraward(doctorId) VALUES(?);INSERT INTO doctormemberships(doctorId) VALUES(?);INSERT INTO doctorregistrations(doctorId) VALUES(?)";
		try
		{
			PreparedStatement ps1 = con.prepareStatement(docDml);
			ps1.setInt(1, doctorId);
			ps1.setInt(2, doctorId);
			ps1.setInt(3, doctorId);
			ps1.setInt(4, doctorId);
			ps1.setInt(5, doctorId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	


	public int getUserId(String mobileNumber)
	{
		String query = "SELECT doctorId FROM doctorprofilesetting WHERE mobileNumber = ?";
		try
		{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, mobileNumber);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return rs.getInt("doctorId");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return 0;
	}

}
