package com.dollop.appointment.service;

import java.io.IOException;
import java.util.ArrayList;
import com.dollop.appointment.dao.*;
import com.dollop.appointment.model.AdminPatientData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminService {

	
	public void showPatientData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDAOImp adi = new AdminDAOImp();
		
		ArrayList<AdminPatientData> patientList = adi.allPatientsData();
		
		request.setAttribute("patientList", patientList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin/patient-list.jsp");
		rd.forward(request, response);
	    	
	}
	
	
	public void editPatientProfileShow(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	  
		 
    //ArrayList<AdminPatientData> patients =adi.PatientData();
		AdminDAOImp adi = new AdminDAOImp();
		
		  String mobile = request.getParameter("mobile");
		  AdminPatientData patients= adi.patientData(mobile);
	  
		  request.setAttribute("patients", patients);
	  
	  RequestDispatcher rd = request.getRequestDispatcher("admin/editPatientProfile.jsp"); 
	  rd.forward(request,response);
	  
	 }
	public void editPatinetProfileUpdate(HttpServletRequest request, HttpServletResponse response) {
			
			
		  String mobile = request.getParameter("mobile");
		  
		  
		  
		  
//		  AdminPatientDataUpdate patients=adi.patientData(mobile);
			
			
	  }

}
