package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	
	private static String drivername;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		ResourceBundle rs = ResourceBundle.getBundle("dbdetails");
		drivername = rs.getString("db.drivername");
		url = rs.getString("db.url");
		username = rs.getString("db.username");
		password = rs.getString("db.password");
		
	}
	
	public static Connection provideConnection() {
		Connection con = null;
		
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			con = DriverManager.getConnection(url,"root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
