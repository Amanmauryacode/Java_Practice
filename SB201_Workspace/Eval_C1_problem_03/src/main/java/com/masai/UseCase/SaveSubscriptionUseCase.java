package com.masai.UseCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.masai.Dao.StreamMasterDAO;
import com.masai.Dao.Impl.StreamMasterDAOImpl;
import com.masai.entity.Subscription;

public class SaveSubscriptionUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
		    
		System.out.print("Enter Name : ");
		String name = sc.next();

		System.out.print("Enter email : ");
		String email = sc.next();

		System.out.print("Enter address : ");
		String address = sc.next();

		System.out.print("Enter plan_name : ");
		String plan_name = sc.next();

		System.out.print("Enter price : ");
		String price = sc.next();

		System.out.print("Enter Start Date [YYYY-MM-DD] : ");
		LocalDate startDate = LocalDate.parse(sc.next(), dateFormat);

		System.out.print("Enter End Date [YYYY-MM-DD] : ");
		LocalDate endDate = LocalDate.parse(sc.next(), dateFormat);

		Subscription sub = new Subscription();
		try {
			sub.setAddress(address);
			sub.setEmail(email);
			sub.setEnd_date(endDate);
			sub.setName(name);
			sub.setPlan_name(plan_name);
			sub.setStart_date(startDate);
			sub.setPrice(Integer.parseInt(price));

			StreamMasterDAO dao = new StreamMasterDAOImpl();

			String msg = dao.saveSubscription(sub);
			System.out.println(msg);
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
