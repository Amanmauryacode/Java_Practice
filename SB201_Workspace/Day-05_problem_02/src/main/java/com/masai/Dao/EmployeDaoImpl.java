package com.masai.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import com.masai.entity.Employee;
import com.masai.exception.EmployeeException;
import com.masai.utility.EMUtil;

public class EmployeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		EntityManager em = EMUtil.provideEntityManager();
		Query q = em.createQuery("from Employee");
		
		List<Employee> list = q.getResultList();
		if(list.isEmpty()) {
			throw new EmployeeException("No Record Found");
		}
		return list;
	}

	@Override
	public List<Employee> getEmployeesByAddress(String address) throws EmployeeException {
		EntityManager em = EMUtil.provideEntityManager();
		Query q = em.createQuery("from Employee e WHERE e.address = :addr");
		
		q.setParameter("addr", address);
		List<Employee> list = q.getResultList();
		if(list.isEmpty()) {
			throw new EmployeeException("No Record Found");
		}
		return list;
	}

	@Override
	public List<Employee> getAllEmployeeWithRangeSalary(int startSalary, int endSalary) throws EmployeeException {
		EntityManager em = EMUtil.provideEntityManager();
		Query q = em.createQuery("from Employee e WHERE e.salary BETWEEN :st AND :end");
		q.setParameter("st", startSalary);
		q.setParameter("end", endSalary);
		
		List<Employee> list = q.getResultList();
		if(list.isEmpty()) {
			throw new EmployeeException("No Record Found");
		}
		return list;
	}

	@Override
	public Object[] getEmployeeNameAndSalary(int empId) throws EmployeeException {
		EntityManager em = EMUtil.provideEntityManager();
		Query q = em.createQuery("select e.name,e.salary from Employee e WHERE e.empId = :id");
		q.setParameter("id", empId);
		
		List<Object[]> list =  q.getResultList();
		if(list.isEmpty()) {
			throw new EmployeeException("No Record Found");
		}
		return list.get(0);
	}

	@Override
	public int getEmployeeSalaryById(int empId) throws EmployeeException {
		EntityManager em = EMUtil.provideEntityManager();
		Query q = em.createQuery("select e.salary from Employee e WHERE e.empId = :id");
		q.setParameter("id", empId);
		
		List<Integer> salary =  q.getResultList();
		if(salary.isEmpty()) {
			throw new EmployeeException("No Record Found");
		}
		return salary.get(0);
	}

}
