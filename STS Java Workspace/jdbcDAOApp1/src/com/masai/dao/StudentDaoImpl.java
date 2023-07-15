package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.model.Student;
import com.masai.utility.DBUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String insetStudentDetails(int roll, String name, String address, int marks) {
		
		String msg = "Not Inserted";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
			
			ps.setInt(1, roll);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setInt(4, marks);
			
			int x = ps.executeUpdate();
			
			if(x >0) {
				msg = "Recod Inserted Sucessfully...!";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg = e.getMessage();
		}
		
		
		
		
		return msg;
		
	}
	@Override
	public String insetStudentDetails2(Student student) {
		String msg = "Not Inserted";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
			
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.setString(3, student.getAddress());
			ps.setInt(4, student.getMarks());
			
			int x = ps.executeUpdate();
			
			if(x >0) {
				msg = "Recod Inserted Sucessfully...!";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg = e.getMessage();
		}
		
		return msg;
	
	}
	@Override
	public int getStudentMarksByRoll(int roll) {
		int marks = -1;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("Select marks from student where roll = ?");
			
			ps.setInt(1, roll);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				marks = rs.getInt("marks");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return marks;
	}
	@Override
	public Student getStudentDetailsByRoll(int roll) {
		Student student = null;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from student where roll = ?");
			
			ps.setInt(1, roll);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int r = rs.getInt("roll");
				String name  = rs.getString("name");
				String address  = rs.getString("address");
				int marks = rs.getInt("marks");
				
				student = new Student();
				
				student.setRoll(r);
				student.setName(name);
				student.setAddress(address);
				student.setMarks(marks);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return student;
	}
	@Override
	public List<Student> getAllStudentDetails() {
		List<Student> students = new ArrayList<>();
		
		try(Connection con =DBUtil.provideConnection()) {
			PreparedStatement ps = con.prepareStatement("select * from student");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int r = rs.getInt("roll");
				String name  = rs.getString("name");
				String address  = rs.getString("address");
				int marks = rs.getInt("marks");
				
				Student student = new Student();
				
				student.setRoll(r);
				student.setName(name);
				student.setAddress(address);
				student.setMarks(marks);
				
				students.add(student);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return students;
	}

	

	
	
}
