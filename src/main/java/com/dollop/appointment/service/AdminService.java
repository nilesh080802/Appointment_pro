	package com.dollop.appointment.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.dollop.appointment.dao.*;
import com.dollop.appointment.model.AdminData;
import com.dollop.appointment.model.DoctorSettingData;
import com.dollop.appointment.model.PatientSettingData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminService {
	AdminDAOImp adi=null;
	
		public AdminService()
		{
			adi=new AdminDAOImp();
		}

	
	public void showPatientData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDAOImp adi = new AdminDAOImp();
		
		ArrayList<PatientSettingData> patientList = adi.allPatientsData();
		
		request.setAttribute("patientList", patientList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin/patient-list.jsp");
		rd.forward(request, response);
	    	
	}
	public void showAdminData(HttpServletRequest request ,HttpServletResponse response )
	{
	    String mobile=request.getParameter("mobile");
	    AdminData ad=new AdminData(); 
	    ad= (AdminData) adi.getAdminData(mobile);
	    request.setAttribute("adminData", ad);
	    
	    System.out.println(ad.getFirstName());
		
	}
	
//	this method is for edit the admin data 
	public void editAdminData(HttpServletRequest request ,HttpServletResponse response)
	{
		AdminData ad=new AdminData();
	
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String dateOfBirth=request.getParameter("dateOfBirth");
		String email=request.getParameter("email");
		String mobileNumber=request.getParameter("mobileNumber");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zipCode=request.getParameter("zipCode");
		String country=request.getParameter("country");
		
		firstName=firstName.trim();
		lastName=lastName.trim();
		dateOfBirth=dateOfBirth.trim();
		email=email.trim();
		mobileNumber=mobileNumber.trim();
		address=address.trim();
		city=city.trim();
		state=state.trim();
		zipCode=zipCode.trim();
		country=country.trim();
		
		ad.setFirstName(firstName);
		ad.setLastName(lastName);
		ad.setDateOfBirth(dateOfBirth);
		ad.setEmail(email);
		ad.setMobileNumber(mobileNumber);
		ad.setAddress(address);
		ad.setCity(city);
		ad.setState(state);
		ad.setZipCode(zipCode);
		ad.setCountry(country);

		adi.editAdminProfileData(ad);
		
	}
	
//	this method is for admin registraion
	public void adminRegistration(HttpServletRequest request , HttpServletResponse response)throws ServletException ,IOException
	{
		AdminData ad=new AdminData();
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String mobileNumber=request.getParameter("mobileNumber");
		String password=request.getParameter("password");
		String conPassword=request.getParameter("conPassword");
		
		firstName=firstName.trim();
		lastName=lastName.trim();
		email=email.trim();
		mobileNumber=mobileNumber.trim();
		password=password.trim();
		conPassword=conPassword.trim();
		
		if( firstName=="" || lastName==""|| email==""|| mobileNumber==""||password=="" || conPassword=="")
		{
			request.setAttribute("registrationError", "Please fill all Details!!!!!");
			RequestDispatcher rd= request.getRequestDispatcher("admin/register.jsp");
			rd.forward(request,response);
		}
		else if(isValid(mobileNumber)) {
			
			if(password.equals(conPassword))
			{
				ad.setFirstName(firstName);
				ad.setLastName(lastName);
				ad.setEmail(email);
				ad.setMobileNumber(mobileNumber);
				ad.setPassword(password);
				ad.setConPassword(conPassword);
				
				adi.insertAdminData(ad);	
				request.setAttribute("registration", "Registration  succesfully !!!!");
				RequestDispatcher rd = request.getRequestDispatcher("./admin/login.jsp");
				rd.forward(request, response);

				
			}
			else {
				request.setAttribute("incorrect", "password does not match !!!!");
				RequestDispatcher rd = request.getRequestDispatcher("./admin/register.jsp");
				rd.forward(request, response);

				
			}
			
		}
		
		
		
		
	}
	



// this method is for show the all doctors data
public void showDoctorData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDAOImp adi = new AdminDAOImp();
		
		ArrayList<DoctorSettingData> patientList = adi.allDoctorsData();
		
		request.setAttribute("patientList", patientList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin/patient-list.jsp");
		rd.forward(request, response);
	    	
	}
	
//	this method is for show the patient profile 
	public void editPatientProfileShow(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	  
		 
    //ArrayList<AdminPatientData> patients =adi.PatientData();
		AdminDAOImp adi = new AdminDAOImp();
		
		  String mobile = request.getParameter("mobile");
		  PatientSettingData patients= adi.patientData(mobile);
	  
		  request.setAttribute("patients", patients);
	  
	  
	  
	 }
	
//	this method is for update patient profile data
	public void editPatinetProfileUpdate(HttpServletRequest request, HttpServletResponse response) {
			
			
		  String mobile = request.getParameter("mobile");
		  
		  
		  
		  
//		  AdminPatientDataUpdate patients=adi.patientData(mobile);
			
			
	  }
	public static boolean isValid(String s) {

		// The given argument to compile() method
		// is regular expression. With the help of
		// regular expression we can validate mobile
		// number.
		// The number should be of 10 digits.

		// Creating a Pattern class object
		Pattern p = Pattern.compile("^\\d{10}$");

		// Pattern class contains matcher() method
		// to find matching between given number
		// and regular expression for which
		// object of Matcher class is created
		java.util.regex.Matcher m = p.matcher(s);

		// Returning boolean value
		return (m.matches());
		}

}
