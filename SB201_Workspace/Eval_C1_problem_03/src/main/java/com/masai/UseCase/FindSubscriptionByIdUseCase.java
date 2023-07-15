package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Dao.StreamMasterDAO;
import com.masai.Dao.Impl.StreamMasterDAOImpl;
import com.masai.entity.Subscription;
import com.masai.exception.SubscriptionException;

public class FindSubscriptionByIdUseCase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Id TO get Subscription Details : ");
		String id = sc.next();

		try {
			StreamMasterDAO dao = new StreamMasterDAOImpl();
			Subscription sub = dao.findSubscriptionById(Integer.parseInt(id));
			System.out.println(sub);
		} catch (SubscriptionException se) {
			System.out.println(se.getMessage());
		} catch (Exception e) {
			System.out.println("Invalid "+e.getMessage());
		}

	}
}
