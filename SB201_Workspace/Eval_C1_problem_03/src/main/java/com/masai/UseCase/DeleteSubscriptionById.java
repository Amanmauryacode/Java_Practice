package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Dao.StreamMasterDAO;
import com.masai.Dao.Impl.StreamMasterDAOImpl;

public class DeleteSubscriptionById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID TO Delete Details : ");
		String id = sc.next();
		
		try {
			StreamMasterDAO dao = new StreamMasterDAOImpl();
			String msg =  dao.deleteSubscriptionById(Integer.parseInt(id));
			System.out.println(msg);
		}catch (SecurityException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
