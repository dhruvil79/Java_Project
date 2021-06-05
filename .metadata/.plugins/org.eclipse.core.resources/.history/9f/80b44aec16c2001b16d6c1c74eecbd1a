package com.helper;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionProvider {
	private static Connection con;
	public static Connection getConnection() {
		try {
			if(con==null)
			{
				Class.forName("com.mysql.jdbc.Driver");// Step 1 : Load The Driver
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstproject", "root", "");
			}
			
			if (con != null) {
				System.out.println("Connected With DB..........");

			} else {
				System.out.println("Not Connected With DB..........");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
}