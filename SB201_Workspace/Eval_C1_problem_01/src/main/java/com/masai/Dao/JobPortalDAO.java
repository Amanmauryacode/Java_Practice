package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import com.masai.entity.Applicant;
import com.masai.exception.ApplicantException;
import com.masai.utility.DBUtil;
import com.masai.utility.EMUtil;

public interface JobPortalDAO {
	Applicant findApplicantById(int id);

	String saveApplicant(Applicant applicant);

	String deleteApplicantById(int id);

	String updateApplicantExperience(int id, int experience);
}




