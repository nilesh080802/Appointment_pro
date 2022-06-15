package com.dollop.appointment.service;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollop.appointment.dao.PatientDAOImp;
import com.dollop.appointment.dao.UserDAOImp;
import com.dollop.appointment.model.PatientSettingData;
import com.dollop.appointment.model.UserData;


public class PatientService 
{
	PatientDAOImp  pdi=null;
	UserDAOImp udi= null;
	
	//Constructor
	public PatientService() 
	{
		udi= new UserDAOImp();
		pdi=new PatientDAOImp();
		
	}
		
	public void patientProfileSettingShowData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		String mobileNumber=request.getParameter("mobile");
		PatientSettingData psd= pdi.patientProfileGetData(mobileNumber);
		 
        request.setAttribute("patient",psd);
		RequestDispatcher rd = request.getRequestDispatcher("profile-settings.jsp");
		rd.forward(request, response);		
	}
	
	
	public void patientProfileSettingInsData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dateOfBirth = request.getParameter("dateOfBirth");
//		Integer age = Integer.parseInt(request.getParameter("Age"));
		String bloodGroup = request.getParameter("bloodGroup");
		String emailId = request.getParameter("emailId");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipCode");
		String country = request.getParameter("country");
		
		/*
		 * InputStream inputstream =null; // input stream of the upload file Part
		 * filePart=request.getPart("photo");
		 * 
		 * 
		 * 
		 * if(filePart!=null) { System.out.println(filePart.getName());
		 * System.out.println(filePart.getSize());
		 * System.out.println(filePart.getContentType());
		 * 
		 * inputstream= filePart.getInputStream();
		 * 
		 * 
		 * }
		 */
		
		
		firstName=firstName.trim();
		lastName=lastName.trim();
		dateOfBirth=dateOfBirth.trim();
		bloodGroup=bloodGroup.trim();
		emailId=emailId.trim();
		mobile = mobile.trim();
		
		address =address.trim();
		city =city.trim();
		state = state.trim();
		zipCode = zipCode.trim();
		country= country.trim();
		
		
		if(firstName=="" ||lastName=="" ||dateOfBirth=="" || bloodGroup=="" || emailId=="" ||  address=="" || city=="" || state=="" || zipCode=="" || country=="" ) {
			
			request.setAttribute("msg","Please Enter details");
			patientProfileSettingShowData(request,response); 
		
		}else {
		
		  PatientSettingData psd = new PatientSettingData();
		  
		  psd.setFirstName(firstName); 
		  psd.setLastName(lastName);
		  psd.setDateOfBirth(dateOfBirth);
		  //psd.setAge(age);
		  psd.setBloodGroup(bloodGroup);
		  psd.setEmailId(emailId);
		  psd.setMobile(mobile);
		  psd.setAddress(address);
		  psd.setCity(city);
		  psd.setState(state);
		  psd.setZipCode(zipCode);
		  psd.setCountry(country);
//		  System.out.println("ppppppp");
//		  psd.setPhoto(inputstream);
		  
		  
		   pdi.patientProfileInsData(psd); 
			
			  request.setAttribute("msg1","Your data updated succesfully");
			 
			  patientProfileSettingShowData(request,response);
			  
			
		  
		}
		
		  
	}
	
	
	public void patientRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobileNumber = request.getParameter("mobileNumber");
		String password=request.getParameter("password");
	try {
		fname=fname.trim();
		lname=lname.trim();
		mobileNumber=mobileNumber.trim();
		password=password.trim();
		
		if( fname==""|| lname=="" || mobileNumber=="" ||password=="" ) {
			request.setAttribute("loginError", "Please Enter details !!!!!!");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			
		}else if(isValid(mobileNumber)) {

			UserData ud = new UserData();
			ud.setFname(fname);
			ud.setLname(lname);
			ud.setMobileNumber(mobileNumber);
			ud.setPassword(password);
			ud.setType(0);
			
			
//			System.out.println(name+"  "+"  "+mobileNumber+"  "+password);
			udi.addUserData(ud);
			request.setAttribute("signup", "SignUp succesfully !!!!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		
		}else{
			
			request.setAttribute("loginError", "Please Enter Valid mobile number !!!!!!");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		// TODO Auto-generated method stub
		
		
	}
	
	
	
	 public static boolean isValid(String s)
	    {
	 
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
