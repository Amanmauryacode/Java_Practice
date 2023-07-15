package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.entity.Applicant;
import com.masai.exception.ApplicantException;
import com.masai.utility.DBUtil;

public class JobPortalDAOJdbcImpl implements JobPortalDAO {

	public Applicant findApplicantById(int id) {
		Applicant app = new Applicant();
		
	   try(Connection con = DBUtil.getConnection()) {
		PreparedStatement ps =  con.prepareStatement("Select * from job_applicant where id = ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			app.setId(rs.getInt("id"));
			app.setEmail(rs.getString("email"));
			app.setAddress(rs.getString("address"));
			app.setCategory(rs.getString("category"));
			app.setExperience(rs.getInt("experience"));
			app.setMobNo(rs.getString("mobNo"));
		}else {
			throw new ApplicantException("Applicant Not Found ");
		}
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	   return app;
	}

	public String saveApplicant(Applicant applicant) {
		String msg = "Not Inserted";
		try(Connection con = DBUtil.getConnection()) {
			PreparedStatement ps =  con.prepareStatement("insert into job_applicant values(?,?,?,?,?,?)");
			ps.setInt(1, applicant.getId());
			ps.setString(2, applicant.getEmail());
			ps.setString(3, applicant.getAddress());
			ps.setString(4, applicant.getMobNo());
			ps.setString(5, applicant.getCategory());
			ps.setInt(6, applicant.getExperience());
			
			int x = ps.executeUpdate();
			if(x >0) {
				msg = "Sucessfully Inserteds";
			}else {
				throw new ApplicantException("Something missing");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return msg;
	}
	
//	id         | int         | NO   | PRI | NULL    |       |
//	| email      | varchar(25) | YES  |     | NULL    |       |
//	| address    | varchar(25) | YES  |     | NULL    |       |
//	| mobNo      | varchar(25) | YES  |     | NULL    |       |
//	| category   | varchar(25) | YES  |     | NULL    |       |
//	| experience

	public String deleteApplicantById(int id) {
		String msg = "Not Deleted";
		try(Connection con = DBUtil.getConnection()) {
			PreparedStatement ps =  con.prepareStatement("delete from job_applicant where id = ?");
			ps.setInt(1, id);
			
			int x = ps.executeUpdate();
			
			if(x >0) {
				msg = "Sucessfully deleted";
			}else {
				throw new ApplicantException("Not found");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return msg;
	}

	public String updateApplicantExperience(int id, int experience) {
		String msg = "Not updated";
		try(Connection con = DBUtil.getConnection()) {
			PreparedStatement ps =  con.prepareStatement("update job_applicant set experience '"+experience+"' where id = '"+id+"' ");
			
			int x = ps.executeUpdate();
			
			if(x >0) {
				msg = "Sucessfully updated";
			}else {
				throw new ApplicantException("Not found");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return msg;
	}
	// Implementation using plain JDBC approach
}
