package com.masai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {

	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Roll to get Student Marks");
		int roll = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/sb101_block24";
		try(Connection conn = DriverManager.getConnection(url,"root","root")) {
			
//			METHOD TO PRINT DATA WHEN WE GET MORE THEN ONE DATA IN RESULT SET;
			
//			PreparedStatement ps = conn.prepareStatement("Select* from student");
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				
//				System.out.println("Roll is : "+rs.getInt("roll"));
//				System.out.println("Name is : "+rs.getString("name"));
//				System.out.println("Address is : "+rs.getString("address"));
//				System.out.println("Marks is : "+rs.getInt("marks"));
//				System.out.println("==================================");
//			}
			
//			METHOD TO PRINT DATA ONLY WHEN WE GET AT MOST ONE DATA IN RESULT SET;
			
//			PreparedStatement ps = conn.prepareStatement("select * from student where roll = ?");
//			
//			ps.setInt(1, roll);
//			ResultSet rs= ps.executeQuery();
//			
//			if(rs.next()) {
//				System.out.println("Roll is : "+rs.getInt("roll"));
//				System.out.println("Name is : "+rs.getString("name"));
//				System.out.println("Address is : "+rs.getString("address"));
//				System.out.println("Marks is : "+rs.getInt("marks"));
//			}else {
//				System.out.println("Student Dose not exist with roll : "+ roll);
//			}
			
			
//			TO GET MARKS OF PARTICULAR STUDENT
			
//			PreparedStatement ps = conn.prepareStatement("select * from student where roll = ?");
//			
//			ps.setInt(1, roll);
//			ResultSet rs= ps.executeQuery();
//			
//			if(rs.next()) {
//				System.out.println("Marks is : "+rs.getInt("marks"));
//			}else {
//				System.out.println("Student Dose not exist with roll : "+ roll);
//			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
