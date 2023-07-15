package com.masai.usecases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.entity.Student;
import com.masai.utility.EMUtil;

public class GetStudentDetailsByCollegeId {

	public static void main(String[] args) {

		EntityManager em = EMUtil.provideEntityManager();

		Query q1 = em.createQuery("select s from Student s WHERE s.college.collageId = :id");

		q1.setParameter("id", 1);

		List<Student> list = q1.getResultList();
		list.forEach(s1 -> {
			System.out.println(s1);
		});

		List<String> list1 = new ArrayList<>();


	}
}
