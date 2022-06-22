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
		String  dql ="SELECT d.firstName,d.lastName,p.paymentId,p.patientId,p.dateTime from paymentinfo p inner JOIN doctorprofilesetting d on p.doctorId =d.doctorId and p.reciptNumber=?";
		
		PaymentSettingData pm=new PaymentSettingData();
		DoctorSettingData dt =new DoctorSettingData();
		PatientSettingData pa=new PatientSettingData();
		try {
			PreparedStatement ps =con.prepareStatement(dql);
			ps.setString(1 ,ob.getReciptNumber());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
			  dt.setFirstName(rs.getString("firstName"));
			  dt.setLastName(rs.getString("lastName"));  
			  list.add(dt);
			  pm.setPaymentId(rs.getInt("paymentId"));	
		      pm.setPatientId(rs.getInt("patientId"));
		      pm.setDoctorId(ob.getDoctorId());
			  pm.setPaymentDate(rs.getString("dateTime"));
			  pm.setReciptNumber(ob.getReciptNumber());
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
		String dml="INSERT INTO `invoice_data`(`patientId`, `doctorId`, `paymentId`) VALUES (?,?,?)";
		
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
		
		String drl1="SELECT invoiceId FROM `invoice_data` WHERE paymentId=?";
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
      
         String dml="UPDATE `invoice_data` SET `orderId`=? WHERE `invoiceId`=?;";
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
		String  dql ="select dps.firstName as dfirstName,dps.lastName as dlastName,dps.address1,dps.address2,dps.city,dps.country,dps.state,dps.postalCode,pps.firstName as pfirstName,pps.lastName as plastName,pps.address,pps.city,pps.state,pps.zipCode,pps.country,pm.paymentId,pm.patientId,pm.cardNumber,pm.cardName,pm.dateTime,pm.paymentType,pm.amount,inv.invoiceDate,inv.orderId from ( ((invoice_data inv inner join doctorprofilesetting dps on inv.doctorId=dps.doctorId)INNER JOIN patientprofilesetting pps on inv.patientId=pps.patientId) inner JOIN paymentinfo pm on inv.paymentId = pm.paymentId and pm.reciptNumber=?)";
		PaymentSettingData pm=new PaymentSettingData();
		DoctorSettingData dt =new DoctorSettingData();
		PatientSettingData pa=new PatientSettingData();
		try {
			PreparedStatement ps =con.prepareStatement(dql);
			ps.setString(1,ob.getReciptNumber());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
			  dt.setDoctorId(ob.getDoctorId());
			  dt.setFirstName(rs.getString("dfirstName"));
			  dt.setLastName(rs.getString("dlastName"));
			  dt.setAddressLine1(rs.getString("address1"));
			  dt.setAddressLine2(rs.getString("address2"));
			  dt.setCity(rs.getString("city"));
			  dt.setCountry(rs.getString("country"));
			  dt.setState(rs.getString("state"));
			  dt.setPostalCode(rs.getString("postalCode"));  
			  list.add(dt);
               
			  pm.setPaymentId(rs.getInt("paymentId"));	
			  pm.setPatientId(rs.getInt("patientId"));
		      pm.setCardNumber(rs.getString("cardNumber"));		  
			  pm.setCardName(rs.getString("cardName"));
			  pm.setPaymentDate(rs.getString("dateTime"));
			  pm.setReciptNumber(ob.getReciptNumber());
			  pm.setPaymentType(rs.getString("paymentType"));
			  pm.setAmount(rs.getDouble("amount"));
			  pm.setInvoiceId(ob.getInvoiceId());
		      pm.setInvoiceDate(rs.getString("invoiceDate"));
		      pm.setOrderId(rs.getString("orderId"));
			  list.add(pm);
			  
			  pa.setPatientId(ob.getPatientId());			
			  pa.setFirstName(rs.getString("pfirstName"));
			  pa.setLastName(rs.getString("plastName"));
			  pa.setAddress(rs.getString("address"));
			  pa.setCity(rs.getString("city"));
			  pa.setState(rs.getString("state"));
			  pa.setZipCode(rs.getString("zipCode"));
			  pa.setCountry(rs.getString("country"));	
			  list.add(pa);		   
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
			 			
		return list;
	}

}
