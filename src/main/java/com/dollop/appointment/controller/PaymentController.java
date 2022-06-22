package com.dollop.appointment.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dollop.appointment.model.PaymentSettingData;
import com.dollop.appointment.service.PaymentService;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")

public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	PaymentService ps= new PaymentService();
	
    public PaymentController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PaymentSettingData pm=ps.fetchDataFromJsp(request);
		
		
		switch(ps.checkAllDetailIsValid(pm)) {
		
		case "FeelAllDetailError":request.setAttribute("PaymentError", "Please fill all details !");
								  RequestDispatcher rd =request.getRequestDispatcher("checkout.jsp");
								  rd.forward(request, response);
		                break;
		case "MobileNumberError": request.setAttribute("PaymentError", "Please enter valid mobile number !");
								  RequestDispatcher rd1 =request.getRequestDispatcher("checkout.jsp");
		 						  rd1.forward(request, response);	
	                	break;
		case "CardDetailError":	  request.setAttribute("PaymentError", "Card detail is not valid !");
								  RequestDispatcher rd2 =request.getRequestDispatcher("checkout.jsp");
								  rd2.forward(request, response);	
		                break;
		case "DetaiIsValid":      if(ps.addPaymentData(pm)) {
			  						ps.getPaymentInfo(pm, request, response);
			                        ps.genrateInvoice(pm,request,response);
			                  
		                          }
								  else
								  {    
									  request.setAttribute("PaymentError", "Payment faild try again!");
									  response.sendRedirect("checkout.jsp");
								  }
		}		
	}
	
	
	

}
