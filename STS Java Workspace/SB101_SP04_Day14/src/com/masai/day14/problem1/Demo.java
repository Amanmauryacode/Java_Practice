package com.masai.day14.problem1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Demo {
	
	static Connection con;
	static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String str = "jdbc:mysql://localhost:3306/sb101_day14";
		return DriverManager.getConnection(str,"root","root");
		
	}
	
	static {
		try {
			con = getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void closeConnection() throws SQLException {
		con.close();
	}
	

		
		
	static void insertCustomer(Scanner sc) throws SQLException {

		System.out.print("Enter Product Id: ");
		int pid = sc.nextInt();
		System.out.print("Enter Product Name: ");
		String pname = sc.next();
		System.out.print("Enter Product Quantity: ");
		int quantity = sc.nextInt();
		System.out.print("Enter Product Price: ");
		int price = sc.nextInt();
		

		Statement st = con.createStatement();
		int row = st.executeUpdate("INSERT INTO product VALUES('"+ pid +"','"+ pname +"'"
				+ ",'"+ quantity +"',"+ price +")");
		if(row>0) 
			System.out.println("Product Added Successfully.");
		   else
			System.out.println("Product Couldn't added.");
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);

		int choice = 0;
		do {
			System.out.println("1. Add Customer");
			System.out.println("2. Update Customer");
			System.out.println("3. Delete Customer");
			System.out.println("4. View Customer List");
			System.out.println("5. Search Customer By Date of Joining according to condition");
			System.out.println("0. Exit");
			
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
				try {
					insertCustomer(sc);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 0:
					System.out.println("Thnaks for using our services");
					break;
				default:
					System.out.println("Invalid Selection, try again later");
			}			
		}while(choice != 0);
		sc.close();
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
