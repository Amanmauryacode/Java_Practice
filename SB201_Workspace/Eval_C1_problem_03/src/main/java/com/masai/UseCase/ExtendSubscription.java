package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Dao.StreamMasterDAO;
import com.masai.Dao.Impl.StreamMasterDAOImpl;

public class ExtendSubscription {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Eneter Id : ");
		String id = sc.next();
		
		System.out.println("Enter No Of Days : ");
		String day = sc.next();
		
		try {
			StreamMasterDAO dao = new StreamMasterDAOImpl();
			
			String msg =  dao.extendSubscription(Integer.parseInt(day), Integer.parseInt(id));
			System.out.println(msg);
		}catch (SecurityException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
