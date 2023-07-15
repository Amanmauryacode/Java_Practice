package com.masai.UseCase;

import java.util.Scanner;

import com.masai.Dao.StreamMasterDAO;
import com.masai.Dao.Impl.StreamMasterDAOImpl;

public class UpdatePlanName {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enetr Id : ");
		String id = sc.next();
		
		System.out.println("Eneter New Plan Name : ");
		String planName = sc.next();
		
		try {
			StreamMasterDAO dao = new StreamMasterDAOImpl();
			
			String msg = dao.updatePlanName(planName, Integer.parseInt(id));
			
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
