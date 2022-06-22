package com.dollop.appointment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		String action= request.getParameter("action");
		System.out.println(action);
	
		
		switch(action) {
		
		case "showPatientsData": as.showPatientsData(request,response);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin/patient-list.jsp");
		rd.forward(request, response);
		break;
		
		case "editPatinetProfileShow": as.editPatientProfileShow(request,response);
		
		RequestDispatcher rd6=request.getRequestDispatcher("admin/editPatientProfile.jsp");
		rd6.forward(request, response);
		break;			
		case "editPatientProfileUpdate":as.editPatientProfileUpdate(request,response);
		
	
		
		as.editPatientProfileShow(request,response);
		RequestDispatcher rdp = request.getRequestDispatcher("admin/editPatientProfile.jsp");
		rdp.forward(request, response);
		
		break;
		
		case "register": as.adminRegistration(request,response); break;
		case "showAdminProfile" : as.showAdminData(request, response); 
		
		RequestDispatcher rdd=request.getRequestDispatcher("admin/profile.jsp");
		rdd.forward(request, response);
		
		break;
		case "editAdminData" : as.editAdminData(request,response);
							   as.showAdminData(request, response);
		
		RequestDispatcher rd2=request.getRequestDispatcher("admin/profile.jsp");
		rd2.forward(request, response);
		break;
		
		case "changeAdminPassword" : 
			
		if(as.changeAdminPassword(request,response))
		{
			
		session.invalidate();
		
		request.setAttribute("changed","Password Successfully Changed");
		response.sendRedirect("admin/login.jsp");
		}else {
			
			
			as.showAdminData(request, response);
			RequestDispatcher rd4=request.getRequestDispatcher("admin/profile.jsp");
			rd4.forward(request, response);
			
		}
		break;
		
		
		
		default:
			RequestDispatcher rde=request.getRequestDispatcher("admin/index.jsp");
			rde.forward(request, response);
		 break;
		
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	

}
