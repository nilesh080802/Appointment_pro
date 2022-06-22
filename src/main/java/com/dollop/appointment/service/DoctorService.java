package com.dollop.appointment.service;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dollop.appointment.dao.DoctorDAOImp;
import com.dollop.appointment.dao.UserDAOImp;
import com.dollop.appointment.model.DoctorSettingData;
import com.dollop.appointment.model.InvoiceView;
import com.dollop.appointment.model.PaymentSettingData;
import com.dollop.appointment.model.UserData;


@MultipartConfig(location = "/tmp",fileSizeThreshold = 1048576,maxFileSize = 20848820,maxRequestSize = 418018841)
public class DoctorService 
{	
	UserDAOImp udi = null;
	DoctorDAOImp ddi = null;
	
	//Constructor
	public DoctorService() 
	{
		udi = new UserDAOImp();
		ddi = new DoctorDAOImp();
	}
	
	public boolean doctorRegistration(HttpServletRequest request, HttpServletResponse response)
	{
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobileNumber = request.getParameter("mobileNumber");
		String password = request.getParameter("password");

		fname = fname.trim();
		lname = lname.trim();
		mobileNumber = mobileNumber.trim();
		password = password.trim();

		if (fname == "" || lname == "" || mobileNumber == "" || password == "") 
		{
			request.setAttribute("loginError", "Please Enter details !!!!!!");
			return false;
		} 
		else if (isValid(mobileNumber)) 
		{
			UserData ud = new UserData();
			ud.setFname(fname);
			ud.setLname(lname);
			ud.setMobileNumber(mobileNumber);
			ud.setPassword(password);
			ud.setType(1);

			udi.addUserData(ud);
			request.setAttribute("signup", "SignUp Successfully!!!!");
			request.setAttribute("mobile", mobileNumber);
			return true;
		} 
		else 
		{
			request.setAttribute("loginError", "Please Enter Valid mobile number !!!!!!");
			return false;
		}
	}

	public DoctorSettingData getDoctor(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
//		String mobileNumber = (String)request.getParameter("mobile");
//		int doctorId = (Integer.parseInt(request.getParameter("doctorId")));
		HttpSession session = request.getSession(false);
		int doctorId = (Integer)session.getAttribute("doctorId");
		String mobileNumber = (String)session.getAttribute("mobileNumber");
		
//		System.out.println("Doctor Id in Service : "+doctorId);
//		System.out.println("Doctor Mobile in Service : "+mobileNumber);
		
		return ddi.getDoctor(mobileNumber, doctorId);
	}
	
	public ArrayList<PaymentSettingData> getAllInvoiceDetails()
	{
		return ddi.getAllInvoiceDetails();
	}
	
	public InvoiceView getInvoiceViewDetails()
	{
		return ddi.getInvoiceViewDetails();
	}
	
	public void doctorProfileSettingInsData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		int doctorId = (Integer)session.getAttribute("doctorId");
		DoctorSettingData dpsd = new DoctorSettingData();
		
		//Get Basic Information of Doctor		
		if(getBasicInfo(dpsd,request, response))
		{
			//Get Education Details of Doctor
			if(getEducationInfo(request,response,dpsd))
			{
				//Get Experience Details of Doctor
				getDoctorExperience(request, response, dpsd);
				
				//Get Award Details of Doctor
				getDoctorAwards(request, response, dpsd);
				
				//Get Membership Details of Doctor
				getDoctorMemberships(request, response, dpsd);
				
				//Get Registration Details of Doctor
				getDoctorRegistrations(request, response, dpsd);;
			
				if(ddi.doctorProfileInsData(dpsd,doctorId))
				{
					request.setAttribute("successMessage", "Updation Succesfully");
//					return true;
				}
				else
				{
					request.setAttribute("failedMsg", "Updation Failed");
//					return false;
				}
			}
			else
			{
//				return false;
			}
		}
		else
		{
//			return false;
		}			
	}

	//---------------------------------------------------------------------------------------------------------------------------------------
	
	public boolean getBasicInfo(DoctorSettingData dpsd,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		String firstName =request.getParameter("firstName");
		firstName=firstName.trim();
		String lastName=request.getParameter("lastName");
		lastName=lastName.trim();
		String mobileNumber=request.getParameter("mobileNumber");
		mobileNumber = mobileNumber.trim();
		String gender=request.getParameter("gender");
		gender=gender.trim();
		String dateOfBirth=request.getParameter("dateOfBirth");
		dateOfBirth=dateOfBirth.trim();
		String biography=request.getParameter("biography");
		biography=biography.trim();
		String clinicName=request.getParameter("clinicName");
		clinicName=clinicName.trim();
		String clinicAddress=request.getParameter("clinicAddress");
		clinicAddress=clinicAddress.trim();
		String addressLine1=request.getParameter("addressLine1");
		addressLine1=addressLine1.trim();
		String addressLine2=request.getParameter("addressLine2");
		addressLine2=addressLine2.trim();
		String city=request.getParameter("city");
		city=city.trim();
		String state=request.getParameter("state");
		state=state.trim();
		String country=request.getParameter("country");
		country=country.trim();
		String postalCode=request.getParameter("postalCode");
		postalCode=postalCode.trim();
		
		//changed
		String pricing = "";
		if("price_free".equals(request.getParameter("rating_option")))
			pricing = "00";
		else if("custom_price".equals(request.getParameter("rating_option")))
			pricing = (request.getParameter("pricing")).trim();
				
		String services=request.getParameter("services");
		services=services.trim();
		
		String specialist=request.getParameter("specialist");
		specialist=specialist.trim();
		
		String imagePath = request.getParameter("image");
		
  		if(firstName=="" || lastName=="" || mobileNumber=="" || gender=="" || dateOfBirth=="" || biography == "" || clinicName=="" || clinicAddress=="" || addressLine1=="" || addressLine2=="" || city=="" || state=="" || country=="" || postalCode=="" || services=="" || specialist=="")
		{
			System.out.println("Please Fill Doctor Basic All Details");
			request.setAttribute("failedMsg", "Please Fill Basic Information !!");
			return false;
		}
  		else
  		{			
			HttpSession session = request.getSession(false);			
			dpsd.setDoctorId((Integer)session.getAttribute("doctorId"));
			 
  			dpsd.setFirstName(firstName);
  			dpsd.setLastName(lastName);
  			dpsd.setMobileNumber(mobileNumber);
  			dpsd.setGender(gender);
  			dpsd.setDateOfBirth(dateOfBirth);
  			dpsd.setBiography(biography);
  			dpsd.setClinicName(clinicName);
  			dpsd.setClinicAddress(clinicAddress);
  			dpsd.setAddressLine1(addressLine1);
  			dpsd.setAddressLine2(addressLine2);
  			dpsd.setCity(city);
  			dpsd.setState(state);
  			dpsd.setCountry(country);
  			dpsd.setPostalCode(postalCode);
  			dpsd.setPricing(pricing);
  			dpsd.setServices(services);
  			dpsd.setSpecialist(specialist);
  			dpsd.setImagePath(imagePath); 
  			return true;
  		}				
	}

//--------------------------------------------------------------------------------------------------------------------------------------	

	public boolean getEducationInfo(HttpServletRequest request,HttpServletResponse response,DoctorSettingData dpsd) throws ServletException, IOException
	{
		ArrayList<Integer> degreeId = new ArrayList<Integer>();
		
		if(request.getParameterValues("degreeId") != null)
		{
			ArrayList<String> dId = new ArrayList<String>(Arrays.asList(request.getParameterValues("degreeId")));
			
			for(String did : dId)				//Convert String ArrayList to Integer
				if(!did.isEmpty())
					degreeId.add(Integer.parseInt(did));		
		}
		
		ArrayList<String> degree = null;
		ArrayList<String> college = null;
		ArrayList<String> yearCompletetion = null;
		
		if(!(request.getParameterValues("degree")[0].isEmpty() && request.getParameterValues("college")[0].isEmpty()  && request.getParameterValues("yearCompletetion")[0].isEmpty()))
		{
			degree = new ArrayList<String>(Arrays.asList(request.getParameterValues("degree")));
			college = new ArrayList<String>(Arrays.asList(request.getParameterValues("college")));
			yearCompletetion = new ArrayList<String>(Arrays.asList(request.getParameterValues("yearCompletetion")));
						
			if(degree.size() == college.size() && degree.size()==yearCompletetion.size() && degree.size()!=0)
			{				
				for(int i=0;i<degree.size();i++)
				{	
					if(degree.get(i).isEmpty() || college.get(i).isEmpty() || yearCompletetion.get(i).isEmpty())
					{
						request.setAttribute("failedMsg", "Please Fill Education Details");
						return false;
						/*
						 * RequestDispatcher rd =
						 * request.getRequestDispatcher("doctor-profile-settings.jsp");
						 * rd.forward(request, response);
						 */
					}
					else
					{	
						degree.set(i, degree.get(i).trim());
						college.set(i, college.get(i).trim());
						yearCompletetion.set(i, yearCompletetion.get(i).trim());
					}	
				}		
				dpsd.setDegreeId(degreeId);
				dpsd.setDegree(degree);
				dpsd.setCollege(college);
				dpsd.setYearCompletetion(yearCompletetion);
				return true;
			}
			else
			{
				System.out.println("Please Fill Education Details Proper");
				request.setAttribute("failedMsg", "Please Fill Education Details !!");
				return false;
//				RequestDispatcher rd = request.getRequestDispatcher("doctor-profile-settings.jsp");
//				rd.forward(request, response);
			}
		}
		else
		{
			System.out.println("Piyush Jaiswal");
			System.out.println("Please Fill All Details of Doctor Education");
			request.setAttribute("failedMsg", "Please Fill Education Details !!");
			return false;
//			RequestDispatcher rd = request.getRequestDispatcher("doctor-profile-settings.jsp");
		
		}
	}
	
	public void getDoctorExperience(HttpServletRequest request,HttpServletResponse response,DoctorSettingData dpsd)
	{
		ArrayList<Integer> hospitalId = new ArrayList<Integer>();
		
		if(request.getParameterValues("hospitalId")!=null)
		{	
			ArrayList<String> hId = new ArrayList<String>(Arrays.asList(request.getParameterValues("hospitalId")));
			
			for(String hid : hId)		//Convert String ArrayList to Integer				
				if(!hid.isEmpty())
					hospitalId.add(Integer.parseInt(hid));	
		}
	
		ArrayList<String> hospitalName = null;
		ArrayList<String> from = null;
		ArrayList<String> to = null;
		ArrayList<String> designation = null;
		
		if(request.getParameterValues("hospitalName") != null && request.getParameterValues("from") != null && request.getParameterValues("to") != null && request.getParameterValues("Designation") != null)
		{
			hospitalName = new ArrayList<String>(Arrays.asList(request.getParameterValues("hospitalName")));
			from = new ArrayList<String>(Arrays.asList(request.getParameterValues("from")));
			to = new ArrayList<String>(Arrays.asList(request.getParameterValues("to")));
			designation = new ArrayList<String>(Arrays.asList(request.getParameterValues("Designation")));
		
			if(hospitalName.size() == from.size() && hospitalName.size() == to.size() && hospitalName.size() == designation.size() && hospitalName.size()!=0)
			{
				for(int i=0;i<hospitalName.size();i++)
				{
					hospitalName.set(i, hospitalName.get(i).trim());
					from.set(i, from.get(i).trim());
					to.set(i, to.get(i).trim());
					designation.set(i, designation.get(i).trim());
				}
				dpsd.setHospitalId(hospitalId);
				dpsd.setHospitalName(hospitalName);
				dpsd.setFrom(from);
				dpsd.setTo(to);
				dpsd.setDesignation(designation);
			}
			else
			{
				System.out.println("Please Fill  Doctor Experience Details Proper");
			}		
		}
		else
		{
			System.out.println("Experience Details Empty");
		}					
	}

	public void getDoctorAwards(HttpServletRequest request,HttpServletResponse response,DoctorSettingData dpsd)
	{
		ArrayList<Integer> awardId = new ArrayList<Integer>();
		ArrayList<String> awardName = null;
		ArrayList<String> awardYear = null;
		
		if(request.getParameterValues("awardId") != null)
		{	
			ArrayList<String> aId = new ArrayList<String>(Arrays.asList(request.getParameterValues("awardId")));
			
			for (String aid : aId) 									//Convert String ArrayList to Integer
				if(!aid.isEmpty())
					awardId.add(Integer.parseInt(aid));
		}
		if(request.getParameterValues("award")!=null && request.getParameterValues("awardYear")!=null)
		{	
			awardName = new ArrayList<String>(Arrays.asList(request.getParameterValues("award")));
			awardYear = new ArrayList<String>(Arrays.asList(request.getParameterValues("awardYear")));
		
			if(awardName.size() == awardYear.size() && awardName.size()!=0)
			{
 				for(int i=0;i<awardName.size();i++)
				{
					awardName.set(i, awardName.get(i).trim());
					awardYear.set(i, awardYear.get(i).trim());
				}
				dpsd.setAwardId(awardId);
				dpsd.setAward(awardName);
				dpsd.setAwardYear(awardYear);
			}
		}	
		else
		{
			System.out.println("Award Info Empty");
		}
	}

	public void getDoctorMemberships(HttpServletRequest request,HttpServletResponse response,DoctorSettingData dpsd)
	{
		ArrayList<Integer> membershipId = new ArrayList<Integer>();
		ArrayList<String> membership = null;
		
		if(request.getParameterValues("membershipId")!=null)
		{	
			ArrayList<String> mId = new ArrayList<String>(Arrays.asList(request.getParameterValues("membershipId")));
			for (String mid : mId) 									//Convert String ArrayList to Integer
				if(!mid.isEmpty())
					membershipId.add(Integer.parseInt(mid));
		}
		if(request.getParameterValues("memberships") != null)
		{
			membership = new ArrayList<String>(Arrays.asList(request.getParameterValues("memberships")));
	
			if(membership.size()!=0)
			{
				for(int i=0;i<membership.size();i++)
					membership.set(i, membership.get(i).trim());
				dpsd.setMembershipId(membershipId);
				dpsd.setMemberships(membership);
			}
		}	
		else
			System.out.println("Membership Block Empty");
	}
	
	public void getDoctorRegistrations(HttpServletRequest request,HttpServletResponse response,DoctorSettingData dpsd)
	{
		ArrayList<Integer> registrationId = new ArrayList<Integer>();
		ArrayList<String> registration = null;
		ArrayList<String> registrationYear = null;
		if(request.getParameterValues("registrationId")!=null)
		{	
			ArrayList<String> rId = new ArrayList<String>(Arrays.asList(request.getParameterValues("registrationId")));
			for (String rid : rId) 									//Convert String ArrayList to Integer
				if(!rid.isEmpty())
					registrationId.add(Integer.parseInt(rid));
		}
		if(request.getParameterValues("registration") != null && request.getParameterValues("registrationYear") != null)
		{
			registration = new ArrayList<String>(Arrays.asList(request.getParameterValues("registration")));
			registrationYear = new ArrayList<String>(Arrays.asList(request.getParameterValues("registrationYear")));
			if(registration.size()!=0 && registration.size() == registrationYear.size())
			{				
				for(int i=0;i<registration.size();i++)
				{
					registration.set(i, registration.get(i).trim());
					registrationYear.set(i, registrationYear.get(i).trim());
				}			
				dpsd.setRegistrationId(registrationId);;
				dpsd.setRegistration(registration);
				dpsd.setRegistrationYear(registrationYear);
			}
		}		
		else
			System.out.println("Registration Block Empty");
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

		public void doctorTimeScheduleData(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			String json = request.getParameter("js");
			
			
				
			
		}


}
