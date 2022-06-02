package com.dollop.appointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dollop.appointment.model.DoctorSettingData;
import com.dollop.appointment.utility.DBConnection;

public class DoctorDAOImp {

static Connection con=null;

	public DoctorDAOImp()
	{
		con=(Connection) DBConnection.openConnection();
	}


// git
	public void doctorProfileInsData(DoctorSettingData dsd)
	{
		try {

		PreparedStatement ps= (PreparedStatement) con.prepareStatement("");

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
		


	}catch(Exception e )	
	{
		e.printStackTrace();
	}
}

}
