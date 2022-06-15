package com.dollop.appointment.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dollop.appointment.dao.AdminDAOImp;
import com.dollop.appointment.dao.UserDAOImp;

public class LoginService {
	
	
	UserDAOImp udi = null;
	AdminDAOImp adi =null;
	public LoginService() {
		udi = new UserDAOImp();
		adi = new AdminDAOImp();

		// TODO Auto-generated constructor stub
	}
	public void userLogin(HttpServletRequest request, HttpServletResponse response,String mobileNumber,String password) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (udi.verifyPassword(password)) {
			
			if (udi.verifyUser(mobileNumber, password)) {
				
				Integer patientId=udi.getPatientId(mobileNumber);
				session.setAttribute("mobileNumber",mobileNumber );
				session.setAttribute("patientId", patientId);
			
				if (udi.identifyUser(mobileNumber)) {
			
					session.setAttribute("type","doctor");
					
					RequestDispatcher rd = request.getRequestDispatcher("doctor-dashboard.jsp");
					rd.forward(request, response);
				} 
				else{

					session.setAttribute("type","patient");
					
					RequestDispatcher rd = request.getRequestDispatcher("patient-dashboard.jsp");
					rd.forward(request, response);

				}
			} else {
				System.out.println("User Not Registred!!");
				request.setAttribute("loginError","User Not Registred!!" );
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("loginError", "Invalid Password !!!");

			System.out.println("Invalid Password !!!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
	}
	
	public void adminLogin(HttpServletRequest request, HttpServletResponse response,String mobileNumber,String password) throws ServletException, IOException {
	
	HttpSession session = request.getSession();

			System.out.println("adminLogin");
			if (adi.verifyPassword(password)) {
			
					if (adi.verifyUser(mobileNumber, password)) {

					session.setAttribute("mobileNumber",mobileNumber );
					
					session.setAttribute("type","admin");
					System.out.println("adminLoginsuccesfully");
					
					RequestDispatcher rd = request.getRequestDispatcher("admin/index.jsp");
					rd.forward(request, response);
				
					} else {
						System.out.println("Admin Not Registred!!");
						request.setAttribute("loginError","Admin Not Registred!!" );
						RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
						rd.forward(request, response);
					}
			} else {
					request.setAttribute("loginError", "Invalid Password !!!");

						System.out.println("Invalid Password !!!");
						RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
						rd.forward(request, response);
		}

		
	}
	
	
}
