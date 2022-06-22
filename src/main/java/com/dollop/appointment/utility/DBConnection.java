package com.dollop.appointment.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String jdbcUrl = "jdbc:mysql://localhost:3306/apointment";
	private static String userName="root";						
	private static String password="";
	
	static Connection connection=null;
	
	public static Connection openConnection() {
		
		if(connection!=null) {
			
			return connection;
		}
		else {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection= DriverManager.getConnection(jdbcUrl,userName,password);
				
			 } catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			 }catch(ClassNotFoundException  e) {
				e.printStackTrace();
			}
		}
		
		return connection;
		
	}

}
