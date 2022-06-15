package com.dollop.appointment.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */

@WebServlet(name = "UploadServlet", urlPatterns = {"/fileuploadservlet"})
@MultipartConfig(
					fileSizeThreshold = 1024 * 1024 * 1,	//1 MB
					maxFileSize = 1024 * 1024 * 10,			//10 MB
					maxRequestSize = 1024 * 1024 * 100		//100MB
				)
public class UploadServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	public UploadServlet() 
	{
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Part filePart = request.getPart("image");
		String name = getFileName(filePart);
		System.out.println(name);
		
		for(Part part : request.getParts())
		{
			name = getFileName(part);
			System.out.println(name);
			part.write("D:\\Java Program\\Appointment_pro\\src\\main\\webapp\\assets\\img\\doctors\\"+name);
		}
		response.getWriter().print("assets/img/patients/"+name);
	}
	
	private String getFileName(Part part)
	{
		String contentDisp = part.getHeader("content-disposition");
		String name = "";
		String [] tokens = contentDisp.split(";");
		
		for(String token : tokens)
		{
			if(token.trim().startsWith("filename"))
			{
				name = token.substring(token.indexOf("=")+2,token.length()-1);
				break;
			}
		}
		try
		{
			tokens = name.split("\\.");
			name = tokens[tokens.length-1];
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		long i = new Date().getTime();
		return "img-"+i+"."+name;
	}
}
