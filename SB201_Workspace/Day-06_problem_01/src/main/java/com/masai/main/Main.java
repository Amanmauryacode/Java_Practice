package com.masai.main;

import javax.persistence.EntityManager;

import com.masai.entity.College;
import com.masai.entity.Student;
import com.masai.utility.EMUtil;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		College c1 = new College();
		c1.setCollageName("Jaipur university");
		c1.setCollageAddress("Jaipur");

		College c2 = new College();
		c2.setCollageName("Patiala university");
		c2.setCollageAddress("Patiala");

		Student s1 = new Student();
		s1.setStudentName("Rounak");
		s1.setEmail("r@gmail.com");
		s1.setMobileNumber("787656767");
		s1.setCollege(c2);

		Student s2 = new Student();
		s2.setStudentName("Rahul");
		s2.setEmail("rahul@gmail.com");
		s2.setMobileNumber("7876767");
		s2.setCollege(c2);

		Student s3 = new Student();
		s3.setStudentName("Shushil");
		s3.setEmail("s@gmail.com");
		s3.setMobileNumber("656767");
		s3.setCollege(c2);
		Student s4 = new Student();
		s4.setStudentName("Ram");
		s4.setEmail("ram@gmail.com");
		s4.setMobileNumber("997656767");
		s4.setCollege(c2);

		c2.getStdList().add(s1);
		c2.getStdList().add(s2);
		c2.getStdList().add(s3);
		c2.getStdList().add(s4);

		Student s5 = new Student();
		s5.setStudentName("Rekha");
		s5.setEmail("rekha@gmail.com");
		s5.setMobileNumber("7656767");
		s5.setCollege(c1);

		Student s6 = new Student();
		s6.setStudentName("Jaya");
		s6.setEmail("jaya@gmail.com");
		s6.setMobileNumber("765886767");
		s6.setCollege(c1);
		Student s7 = new Student();
		s7.setStudentName("Sushma");
		s7.setEmail("sushma@gmail.com");
		s7.setMobileNumber("007656767");
		s7.setCollege(c1);

		Student s8 = new Student();
		s8.setStudentName("Kammo");
		s8.setEmail("kammo@gmail.com");
		s8.setMobileNumber("667656767");
		s8.setCollege(c1);
		
		c1.getStdList().add(s5);
		c1.getStdList().add(s6);
		c1.getStdList().add(s7);
		c1.getStdList().add(s8);
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.getTransaction().commit();
		
		em.close();
		System.out.println("Done...");
		
	}

}
