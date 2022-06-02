package com.dollop.appointment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollop.appointment.dao.UserDAOImp;
import com.dollop.appointment.model.DoctorSettingData;
import com.dollop.appointment.model.UserData;
import com.dollop.appointment.service.DoctorService;

/**
 * Servlet implementation class DoctorController
 */
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	DoctorService ds = null;
	public DoctorController() {
		ds = new DoctorService();
	

	// TODO Auto-generated constructor stub
	}

	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	*      response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	// TODO Auto-generated method stub

	doPost(request, response);
	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	*      response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	String action=request.getParameter("action");
	switch(action)
	{
	   case "register":  ds.doctorRegistration(request,response);break;

	   case "profileSettingInsData": ds.doctorProfileSettingInsData(request,response);break;

	}
	// TODO Auto-generated method stub

	}

	


}
