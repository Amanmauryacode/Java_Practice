package com.masai.Demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.masai.entity.Employee;

public class Demo {
	   public static void main( String[ ] args ) {
	   
	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "employee" );
	      EntityManager entitymanager = emfactory.createEntityManager();
	     
			
			 //write your logic here      
	      Query query = entitymanager.createNamedQuery("Employee.FindAllEmployee");
	      
	      List<Employee> list = query.getResultList();
	      
	      list.forEach(System.out::println);
	      
	      Query q = entitymanager.createNamedQuery("Employee.FindEmployeeByName");
	      
	      q.setParameter(1, "Ram");
	      List<Employee> emp = q.getResultList();
	      
	      emp.forEach(System.out::println);
	      
	   }   
	}
