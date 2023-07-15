package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.GetJob;
import com.masai.Dao.JobPortalDAO;

public class DeleteApplicant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println( "Enter Aproach [ORM / JDBC] : ");
		String aproach = sc.next();
		
		System.out.println("Enter ID : ");
		String Id = sc.next();
		
		try {
			JobPortalDAO dao = GetJob.getInstanceofJobPortalDAO(aproach);
			String msg = dao.deleteApplicantById(Integer.parseInt(Id));
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
