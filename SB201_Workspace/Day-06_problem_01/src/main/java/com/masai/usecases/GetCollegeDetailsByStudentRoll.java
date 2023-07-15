package com.masai.usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.entity.Student;
import com.masai.utility.EMUtil;

public class GetCollegeDetailsByStudentRoll {

	public static void main(String[] args) {
		EntityManager em = EMUtil.provideEntityManager();
		
		Query q1 = em.createQuery("select s from Student s WHERE s.studentRoll = :id");
		
		q1.setParameter("id", 8);
		
		List<Student>  list = q1.getResultList();
		
		list.forEach(s->{
			System.out.println(s.getCollege().getCollageId());
			System.out.println(s.getCollege().getCollageName());
			System.out.println(s.getCollege().getCollageAddress());
		});
		
	}
}
