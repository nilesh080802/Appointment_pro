package com.dollop.appointment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dollop.appointment.service.AdminService;
import com.dollop.appointment.service.LoginService;

/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**   
	 * @see HttpServlet#HttpServlet()
	 */
	LoginService ls = null;

	AdminService as=null;
	public LoginController() {

		ls = new LoginService();
		as=new AdminService();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doPost(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String action=request.getParameter("action");


		String mobileNumber = request.getParameter("mobileNumber");
		String password = request.getParameter("password");
		
		if(mobileNumber!=null && password!=null) 
		{

			mobileNumber = mobileNumber.trim();
			password = password.trim();
		}

		if (mobileNumber == "" || password == "") {

			//here we set a messseg  for showing on jsp page
			
			request.setAttribute("loginError", "Please Fill required details !!!");
			if(action.equals("userLogin")) 
			{
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);

			}
			else if(action.equals("adminLogin")) 
			{
				RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
				rd.forward(request, response);

			}			
		} 
		else 
		{
//			System.out.println(action+"   :main action else");
			if(action.equals("userLogin")) 
			{
				ls.userLogin(request,response,mobileNumber,password);

			}
			else if(action.equals("adminLogin")) 
			{
				ls.adminLogin(request,response,mobileNumber,password);
			}
			else if(action.equals("logout")) 
			{				
//				System.out.println(action+"   :main action logout");
				session.invalidate();
				response.sendRedirect("index-2.jsp");					  					  
			}					 
		}		
	}
}