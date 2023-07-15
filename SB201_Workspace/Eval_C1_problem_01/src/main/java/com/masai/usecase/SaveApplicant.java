package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.GetJob;
import com.masai.Dao.JobPortalDAO;
import com.masai.entity.Applicant;

public class SaveApplicant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println( "Enter Aproach [ORM / JDBC] : ");
		String aproach = sc.next();
		
		System.out.println("Enter ID : ");
		String Id = sc.next();
		
		System.out.println("Enter Email : ");
		String email = sc.next();
		
		System.out.println("Enter address : ");
		String address = sc.next();
		
		System.out.println("Enter mobNo : ");
		String mobNo = sc.next();
		
		System.out.println("Enter Category : ");
		String Category = sc.next();
		
		System.out.println("Enter Experience : ");
		String Experience = sc.next();
		
		Applicant app = new Applicant();
		
		try {
			app.setId(Integer.parseInt(Id));
			app.setEmail(email);
			app.setAddress(address);
			app.setMobNo(mobNo);
			app.setCategory(Category);
			app.setExperience(Integer.parseInt(Experience));
			
			JobPortalDAO dao = GetJob.getInstanceofJobPortalDAO(aproach);
			String msg = dao.saveApplicant(app);
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
