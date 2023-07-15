package com.masai.usecases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.masai.model.Student;
@Component(value = "jdbc")
public class Jdbc {
	@Autowired
	private Environment env;

	private Connection con;

	@PostConstruct
	public void myInit() {

		try {
			Class.forName(env.getProperty("db.drivername"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(env.getProperty("db.url"), env.getProperty("db.username"),env.getProperty("db.password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertStudent(Student student) {
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into student values (?,?,?)");
			
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.setString(3, student.getAddress());
			
			int x = ps.executeUpdate();
			if(x>0) {
				System.out.println("Student Data Inserted ...");
			}else {
				System.out.println("Student Data Not Inserted...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
