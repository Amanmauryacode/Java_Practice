package com.masai.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Demo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
			
		System.out.print("Enter roll to delete the student : ");
		int roll = sc.nextInt();
		
//		System.out.print("Enter Name : ");
//		String name = sc.next();
//		
//		System.out.print("Enter Address : ");
//		String addr = sc.next();
//		
//		System.out.print("Enter Marks : ");
//		int Marks = sc.nextInt();
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}


		
		String url = "jdbc:mysql://localhost:3306/sb101_block24";
		
		try( Connection con = DriverManager.getConnection(url,"root","root")) {
		
			
//			Statement st =  con.createStatement();
//			
//			int x = st.executeUpdate("insert into student values("+roll+",'"+name+"','"+addr+"',"+Marks+")");
//			if(x>0) {
//				System.out.println("Record inserted sucessfully...");
//			}else {
//				System.out.println("Not inserted...");
//			}
			
//			PreparedStatement pt = con.prepareStatement("insert into student values(?,?,?,?)");
//			
//			pt.setInt(1, roll);
//			pt.setString(2, name);
//			pt.setString(3, addr);
//			pt.setInt(4, Marks);
//			int x = pt.executeUpdate();
//			
//			if(x>0) {
//				System.out.println("Record inserted sucessfully...");
//			}else {
//				System.out.println("Not inserted...");
//			}
			
			
//			PreparedStatement pt =  con.prepareStatement("update student set marks = marks+ ? where marks <600");
//			
//			pt.setInt(1, gmarks);
//			
//			int x = pt.executeUpdate();
//			
//
//			if(x>0) {
//				System.out.println(x + " record are updated sucessfully");
//			}else {
//				System.out.println("No record updated...");
//			}
			
			
			PreparedStatement ps =  con.prepareStatement("delete from student where roll = ?");
			
			ps.setInt(1, roll);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				System.out.println("Sucessfully Deleted...");
			else
				System.out.println("Not Deleted...");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}
