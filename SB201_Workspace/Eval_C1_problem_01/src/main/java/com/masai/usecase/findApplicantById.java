package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.GetJob;
import com.masai.Dao.JobPortalDAO;
import com.masai.entity.Applicant;

public class findApplicantById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println( "Enter Aproach [ORM / JDBC] : ");
		String aproach = sc.next();
		
		System.out.println("Enter ID : ");
		String Id = sc.next();
		
		try {
			JobPortalDAO dao = GetJob.getInstanceofJobPortalDAO(aproach);
			Applicant app = dao.findApplicantById(Integer.parseInt(Id));
			System.out.println(app);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
