package com.masai.Dao.Impl;

import javax.persistence.EntityManager;

import com.masai.Dao.EmployeeDao;
import com.masai.Entity.Employee;
import com.masai.Exception.EmployeeException;
import com.masai.Utitlity.EMUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public String registerEmployee(Employee employee) {
		
		EntityManager em =  EMUtil.getEntityManager();
		String msg = "Sucessfully Inserted ";
		if(employee == null) throw new EmployeeException("Empty Employee Details");
		
		Employee emp = em.find(Employee.class, employee.getEmpID());
		if(emp != null) throw new EmployeeException("Duplicate ID");
		
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		em.close();
		return msg;
	}

	public Employee getEmployeeById(int empId) {
		
		EntityManager em = EMUtil.getEntityManager();
		Employee emp = em.find(Employee.class, empId);
		if(emp != null)return emp;
		throw new EmployeeException("Employee Not Exist");
		
	}

	public String deleteEmployeeById(int empId) {
		EntityManager em = EMUtil.getEntityManager();
		Employee emp = em.find(Employee.class, empId);
		
		if(emp != null) {
			em.getTransaction().begin();
			em.remove(emp);
			em.getTransaction().commit();
		}else {
			throw new EmployeeException("Employee Not Exist");
		}
		return "Sucessfully Deleted ";
		
	}

	public String updateEmployeeSalary(int empId, int amount) {
		
		EntityManager em = EMUtil.getEntityManager();
		Employee emp = em.find(Employee.class, empId);
		
		if(emp != null) {
			em.getTransaction().begin();
			emp.setSalary(amount);
			em.getTransaction().commit();
		}else {
			throw new EmployeeException("Employee Not Exist");
		}
		return "Sucessfully Updated ";
		
	}

}
