package com.dollop.appointment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dollop.appointment.service.AdminService;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	AdminService as = null;
    public AdminController() {
    	as= new AdminService();
       
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
		System.out.println(action);
		
		switch(action) {
		
		case "showPatinetData": as.showPatientData(request,response);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin/editPatientProfile.jsp"); 
		  rd.forward(request,response);
		break;
		
		case "editPatinetProfileShow": as.editPatientProfileShow(request,response);break;
					
		case "editPatinetProfileUpdate":as.editPatinetProfileUpdate(request,response);break;
		
		case "register": as.adminRegistration(request,response); break;
		case "showAdminProfile" : as.showAdminData(request, response); 
		
		RequestDispatcher rdd=request.getRequestDispatcher("admin/profile.jsp");
		rdd.forward(request, response);
		
		break;
		case "editAdminData" : as.editAdminData(request,response);
		
		RequestDispatcher rd2=request.getRequestDispatcher("admin/profile.jsp");
		rd2.forward(request, response);
		break;
		
		
		default:
			RequestDispatcher rde=request.getRequestDispatcher("admin/index.jsp");
			rde.forward(request, response);
		 break;
		
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	

}
