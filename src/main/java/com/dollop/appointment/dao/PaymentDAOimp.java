package com.dollop.appointment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dollop.appointment.model.DoctorSettingData;
import com.dollop.appointment.model.PatientSettingData;
import com.dollop.appointment.model.PaymentSettingData;
import java.util.ArrayList;
import com.dollop.appointment.utility.DBConnection;

public class PaymentDAOimp {

	Connection con=null;
	public PaymentDAOimp() {
		super();
		con=(Connection) DBConnection.openConnection();

	}

	public Boolean addPaymentData(PaymentSettingData pm) {
		boolean flag=false;
		
		String dml="INSERT INTO `paymentinfo`(`patientId`, `doctorId`, `cardName`, `cardNumber`,`reciptNumber`, `paymentType`, `amount`) VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(dml);
			ps.setInt(1, pm.getPatientId());
			ps.setInt(2, pm.getDoctorId());
		    ps.setString(3, pm.getCardName());
			ps.setString(4, pm.getCardNumber());
			ps.setString(5, pm.getReciptNumber());
			ps.setString(6, pm.getPaymentType());
			ps.setDouble(7, pm.getAmount());
			
			flag=ps.executeUpdate()>0?true:false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList getPaymentInfo(PaymentSettingData ob) {
		
		ArrayList list =new ArrayList();
		String  dql ="SELECT * FROM  doctorprofilesetting where doctorId=?";
		
		PaymentSettingData pm=new PaymentSettingData();
		DoctorSettingData dt =new DoctorSettingData();
		PatientSettingData pa=new PatientSettingData();
		try {
			PreparedStatement ps =con.prepareStatement(dql);
			ps.setInt(1 ,ob.getDoctorId());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
			  dt.setDoctorId(rs.getInt("doctorId"));
			  dt.setFirstName(rs.getString("firstName"));
			  dt.setLastName(rs.getString("lastName"));  
			  list.add(dt);
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
			 
			  String  dql1 ="SELECT * FROM  paymentInfo where reciptNumber=?";
        try {      
			  PreparedStatement pd =con.prepareStatement(dql1);
				pd.setString(1 ,ob.getReciptNumber());
				ResultSet rs1 = pd.executeQuery();
				
			  if(rs1.next()) {	
		      pm.setPaymentId(rs1.getInt("paymentId"));	
		      pm.setPatientId(rs1.getInt("patientId"));
		      pm.setDoctorId(rs1.getInt("doctorId"));
			  pm.setPaymentDate(rs1.getString("dateTime"));
			  pm.setReciptNumber(rs1.getString("reciptNumber"));
			  pm.setInvoiceId(ob.getInvoiceId());
			  list.add(pm);
			  } 	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}

	public Integer addInvoiceData(PaymentSettingData pm) {
		
		Integer invoiceId=null;
		String dml="INSERT INTO `invoice_info`(`patientId`, `doctorId`, `paymentId`) VALUES (?,?,?)";
		
		try {
			PreparedStatement ps =con.prepareStatement(dml);
		    ps.setInt(1, pm.getPatientId());
		    ps.setInt(2,pm.getDoctorId());
		    ps.setInt(3, pm.getPaymentId());
		 
		    ps.executeUpdate();
		}
		catch(SQLException e) {
		         e.printStackTrace();	
		}
		
		String drl1="SELECT invoiceId FROM `invoice_info` WHERE paymentId=?";
		try {
			PreparedStatement ps =con.prepareStatement(drl1);
		    ps.setInt(1, pm.getPaymentId());
		 
		    ResultSet rs=ps.executeQuery();
		    
		    if(rs.next())
		    {
		    	invoiceId=rs.getInt("invoiceId");
		    
		    }
		}
		catch(SQLException e) {
		         e.printStackTrace();	
		}
		
		return invoiceId;
	}

	public void addOrderId(String orderId,Integer invoiceId) {
      
         String dml="UPDATE `invoice_info` SET `orderId`=? WHERE `invoiceId`=?;";
		  System.out.println(orderId);
		try {
			PreparedStatement ps =con.prepareStatement(dml);
		    ps.setString(1, orderId);
		    ps.setInt(2,invoiceId);
		    ps.executeUpdate();
		}
		catch(SQLException e) {
		         e.printStackTrace();	
		}
		
	}

	public ArrayList getInvoiceData(PaymentSettingData ob) {
		ArrayList list =new ArrayList();
		String  dql ="SELECT * FROM  doctorprofilesetting where doctorId=?";
		
		PaymentSettingData pm=new PaymentSettingData();
		DoctorSettingData dt =new DoctorSettingData();
		PatientSettingData pa=new PatientSettingData();
		try {
			PreparedStatement ps =con.prepareStatement(dql);
			ps.setInt(1 ,ob.getDoctorId());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
			  dt.setDoctorId(rs.getInt("doctorId"));
			  dt.setFirstName(rs.getString("firstName"));
			  dt.setLastName(rs.getString("lastName"));
			  dt.setMobileNumber(rs.getString("mobileNumber"));
			  dt.setAddressLine1(rs.getString("address1"));
			  dt.setAddressLine2(rs.getString("address2"));
			  dt.setCity(rs.getString("city"));
			  dt.setCountry(rs.getString("country"));
			  dt.setState(rs.getString("state"));
			  dt.setPostalCode(rs.getString("postalCode"));  
			  list.add(dt);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
			 
			  String  dql1 ="SELECT * FROM  paymentInfo where reciptNumber=?";
             
	      try {		  
			    PreparedStatement pd =con.prepareStatement(dql1);
				pd.setString(1 ,ob.getReciptNumber());
				ResultSet rs1 = pd.executeQuery();
				
			  if(rs1.next()) {	
		      pm.setPaymentId(rs1.getInt("paymentId"));	
			  pm.setPatientId(rs1.getInt("patientId"));
		      pm.setCardNumber(rs1.getString("cardNumber"));		  
			  pm.setCardName(rs1.getString("cardName"));
			  pm.setPaymentDate(rs1.getString("dateTime"));
			  pm.setReciptNumber(rs1.getString("reciptNumber"));
			  pm.setPaymentType(rs1.getString("paymentType"));
			  pm.setAmount(rs1.getDouble("amount"));
			  } 
	      }
	      catch(Exception e){
				e.printStackTrace();
			}
			
			
			String dql2="SELECT * FROM patientprofilesetting where patientId=?";
			
			try {
				PreparedStatement ps1 =con.prepareStatement(dql2);
				ps1.setInt(1,ob.getPatientId());
				ResultSet rs2 = ps1.executeQuery();
				
				if(rs2.next()) {
					
					pa.setFirstName(rs2.getString("firstName"));
					pa.setLastName(rs2.getString("lastName"));
					pa.setMobile(rs2.getString("mobile"));
					pa.setAddress(rs2.getString("address"));
					pa.setCity(rs2.getString("city"));
					pa.setState(rs2.getString("state"));
					pa.setZipCode(rs2.getString("zipCode"));
					pa.setCountry(rs2.getString("country"));	
					list.add(pa);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			 String  dql3 ="SELECT * FROM  invoice_info where invoiceId=?";
				try {
					
		             
					PreparedStatement pd =con.prepareStatement(dql3);
					pd.setInt(1 ,ob.getInvoiceId());
					ResultSet rs1 = pd.executeQuery();
						
				    if(rs1.next()){	
					    
				       pm.setInvoiceId(rs1.getInt("invoiceId"));
				       pm.setInvoiceDate(rs1.getString("invoiceDate"));
				       pm.setOrderId(rs1.getString("orderId"));
				    } 
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				list.add(pm);
				
		return list;
	}

}
