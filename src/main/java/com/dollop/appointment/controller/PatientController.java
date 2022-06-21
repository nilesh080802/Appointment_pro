package com.dollop.appointment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollop.appointment.service.PatientService;
import com.dollop.appointment.service.PaymentService;

/**
 * Servlet implementation class PatientController
 */
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
	
	PatientService ps =null;
	
    public PatientController() {
    	ps=new PatientService();
    	
    	
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action= request.getParameter("action");
		
		switch(action) {
		case "register":  ps.patientRegistration(request,response);break;
		
		case "profileSettingInsData": ps.patientProfileSettingInsData(request,response);break;
		
		case "profileSettingShowData": ps.patientProfileSettingInsData(request,response);break;
		
		case "Booking": ps.BookingData(request,response);break;
		
		case "view_invoice": ps.getInvoiceData(request,response);break;
			               
		
		default :
		
		}

			
		
	}
	


}
