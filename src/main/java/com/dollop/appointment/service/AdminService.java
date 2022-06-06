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
	




public void showDoctorData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDAOImp adi = new AdminDAOImp();
		
		ArrayList<DoctorSettingData> patientList = adi.allDoctorsData();
		
		request.setAttribute("patientList", patientList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin/patient-list.jsp");
		rd.forward(request, response);
	    	
	}
	
	
	public void editPatientProfileShow(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	  
		 
    //ArrayList<AdminPatientData> patients =adi.PatientData();
		AdminDAOImp adi = new AdminDAOImp();
		
		  String mobile = request.getParameter("mobile");
		  PatientSettingData patients= adi.patientData(mobile);
	  
		  request.setAttribute("patients", patients);
	  
	  
	  
	 }
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
