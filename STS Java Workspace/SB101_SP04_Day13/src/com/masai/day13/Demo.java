package com.masai.day13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String str = "jdbc:mysql://localhost:3306/sb101_block24";
		
		try {
			Connection con = DriverManager.getConnection(str, "root","root");
			
			Statement st = con.createStatement();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
