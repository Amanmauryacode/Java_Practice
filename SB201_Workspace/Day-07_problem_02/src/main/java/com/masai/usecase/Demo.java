package com.masai.usecase;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.entity.MasaiStudent;
import com.masai.utility.EMUtil;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager em = EMUtil.provideEntityManager();
		System.out.print("Enter Student Name : ");
		String name = sc.next();

		Query q = em.createQuery("from MasaiStudent ms WHERE ms.name = :nm");

		q.setParameter("nm", name);
		MasaiStudent ms = (MasaiStudent) q.getSingleResult();
		
		System.out.println(ms.payFee());
		ms.displayDetails();
	}
}
