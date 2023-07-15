package com.masai.operation;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.Bean.Mobile;
import com.masai.DAO.MobileDao;
import com.masai.DAO.MobileDaoImpl;

public class Main {
	
	public void AddMobileDetails() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Mobile Id : ");
		int id = sc.nextInt();
		
		System.out.println("Enter Model No : ");
		String model_no = sc.next();
		
		System.out.println("Enter Company : ");
		String company = sc.next();
		
		System.out.println("Enter Price : ");
		int price = sc.nextInt();
		
		System.out.println("Enter MF Date : ");
		LocalDate MfgDate = LocalDate.parse(sc.next());
		
		Mobile mob = new Mobile();
		mob.setId(id);
		mob.setModel_no(model_no);
		mob.setCompany(company);
		mob.setPrice(price);
		mob.setMFGdate(MfgDate);
		
		MobileDao dao = new MobileDaoImpl();
		
		String result = dao.AddMobile(mob);
		
		System.out.println(result);
		
		
	}
	
	
	public void UpdateMobile() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Mobile Id To Updation : ");
		int id = sc.nextInt();
				
		System.out.println("Enter Company : ");
		String company = sc.next();
		
		System.out.println("Enter Price  : ");
		int price = sc.nextInt();
		
		System.out.println("Enter Manufacturing Date : ");
		LocalDate MfgDate = LocalDate.parse(sc.next());
		
		Mobile mob = new Mobile();
		mob.setId(id);
		mob.setCompany(company);
		mob.setPrice(price);
		mob.setMFGdate(MfgDate);
		
		MobileDao dao = new MobileDaoImpl();
		
		String result = dao.UpdateMobileDetails(mob);
		
		System.out.println(result);
		
	}
	
	
	public void DeleteMob() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Mobile Id To Delete the Details : ");
		int id = sc.nextInt();
		
		MobileDao dao = new MobileDaoImpl();
		
		String result = dao.deleteMobile(id);
		
		System.out.println(result);
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		Main m = new Main();
		
//		m.AddMobileDetails();
		
		m.DeleteMob();
		
	}
	
	
}
