package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Dao.StreamMasterDAO;
import com.masai.Dao.Impl.StreamMasterDAOImpl;
import com.masai.exception.SubscriptionException;

public class UpdatePrice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id : ");
		String id = sc.next();
		
		System.out.println("Eneter new Price : ");
		String price  = sc.next();
		
		try {
			StreamMasterDAO dao = new StreamMasterDAOImpl();
			 String msg =  dao.updatePrice(Integer.parseInt(price),Integer.parseInt(id));
			System.out.println(msg);
		}catch (SubscriptionException e) {
			System.out.println(e.getMessage());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
