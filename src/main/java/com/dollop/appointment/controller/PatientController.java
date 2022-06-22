package com.dollop.appointment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollop.appointment.service.PatientService;

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
		System.out.println(action+"-action");
		
		System.out.println();
		
		switch(action) {
		case "register":  ps.patientRegistration(request,response);break;
		
		
		case "profileSettingInsData": ps.patientProfileSettingInsData(request,response);
		 RequestDispatcher rd = request.getRequestDispatcher("profile-settings.jsp");
		  rd.forward(request, response);
		break;
		
		case "profileSettingShowData": ps.patientProfileSettingShowData(request,response);
		RequestDispatcher rd1 = request.getRequestDispatcher("profile-settings.jsp");
		 rd1.forward(request, response);
		break;
		 
		case "PatientDashboardShowData": ps.patientDahsboardData(request,response);

		RequestDispatcher rd2 = request.getRequestDispatcher("patient-dashboard.jsp");
		 rd2.forward(request, response);
		break;
		
		
		case "addRemoveFavourites": ps.addRemoveFavouritesData(request,response);
			
		 break;
		
		
		
		case "PatientFavouritesShowData": 
//			ps.patientProfileSettingShowData(request,response);
			
			ps.patientsFavouritesShow(request,response);
			RequestDispatcher rd3 = request.getRequestDispatcher("favourites.jsp");
			 rd3.forward(request, response);
		break;
		
		case "PatientChangePasswordShowData": ps.patientProfileSettingShowData(request,response);
		RequestDispatcher rd4 = request.getRequestDispatcher("change-password.jsp");
		 rd4.forward(request, response);
		 break;
		
		case "doctorProfile" :ps.doctorProfileShowData(request,response);
		RequestDispatcher rd5 = request.getRequestDispatcher("doctor-profile.jsp");
		rd5.forward(request, response);
		
		
		break;
			
		default :
		
		}

			
		
	}
	


}
