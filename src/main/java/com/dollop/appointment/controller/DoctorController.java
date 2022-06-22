package com.dollop.appointment.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollop.appointment.dao.UserDAOImp;
import com.dollop.appointment.model.DoctorSettingData;
import com.dollop.appointment.model.PaymentSettingData;
import com.dollop.appointment.model.UserData;
import com.dollop.appointment.service.DoctorService;

/**
 * Servlet implementation class DoctorController
 */
public class DoctorController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	DoctorService ds = null;
	
	public DoctorController() 
	{
		ds = new DoctorService();
	}

	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	*      response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	*      response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		
		System.out.println(action);
		switch(action)
		{
		   case "register":  
  			   if(ds.doctorRegistration(request,response))
  			   {
  				 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
  				 rd.forward(request, response);
  			   }
  			   else
  			   {
  				 RequestDispatcher rd = request.getRequestDispatcher("doctor-profile-settings.jsp");
  				 rd.forward(request, response);
  			   }
  			   break;
	
		   case "profileSettingInsData": 
			   	ds.doctorProfileSettingInsData(request,response);
			   	request.setAttribute("doctor", ds.getDoctor(request,response));
			   	RequestDispatcher rd = request.getRequestDispatcher("doctor-profile-settings.jsp");
				rd.forward(request, response);
				break;
		   
		   case "getDoctorDetails" :
			   
			    DoctorSettingData doctor = ds.getDoctor(request,response);
			    request.setAttribute("doctor", doctor);
			    RequestDispatcher rd3 = request.getRequestDispatcher("doctor-profile-settings.jsp");
			    rd3.forward(request, response);
			    break;
		   
		   case "getAllInvoiceDetails" :
		   		ArrayList<PaymentSettingData> invoiceList = ds.getAllInvoiceDetails();
		   		request.setAttribute("invoiceDetails", invoiceList);
		   		RequestDispatcher rd4 = request.getRequestDispatcher("invoices.jsp");
			    rd4.forward(request, response);
			    break;
			    
		   case "getInvoiceDetails":
			   	request.setAttribute("invoiceDetails", ds.getInvoiceViewDetails());
			   	RequestDispatcher rd5 = request.getRequestDispatcher("invoice-view.jsp");
			   	rd5.forward(request, response);
			    break;
		}		
	}
}
