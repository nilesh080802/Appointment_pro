package com.dollop.appointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dollop.appointment.model.UserData;
import com.dollop.appointment.utility.DBConnection;

public class UserDAOImp {


	static Connection con=null;
	public UserDAOImp() {
		System.out.println(con);
		System.out.println(con);
		System.out.println(con);
		System.out.println(con);
		System.out.println(con);
		
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
		
		
		try {			
			PreparedStatement ps = con.prepareStatement(dml);
			ps.setString(1,ud.getFname());
			ps.setString(2,ud.getLname());
			ps.setString(3, ud.getMobileNumber());
			ps.setString(4, ud.getPassword());
			ps.setInt(5, ud.getType());
			
			ps.executeUpdate();
		
			if(ud.getType()==0) {
				String dmlpps="insert into patientprofilesetting(firstName,lastName,mobile) values(?,?,?)";
				PreparedStatement ps2 = con.prepareStatement(dmlpps);
				ps2.setString(1,ud.getFname());
				ps2.setString(2,ud.getLname());
				ps2.setString(3, ud.getMobileNumber());
			
				ps2.executeUpdate();
				
				generatePatientId(ud.getMobileNumber());
				
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
	}
	
	public boolean identifyUser(String mobileNumber) {
		
	//This method for identify user ->is user doctor or patient
		String dql = "select type from userdata where mobileNumber=?";
		try {
			
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
		System.out.println(mobileNumber+"  "+password);
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
		String dql = "select * from userdata where  password=?";
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
