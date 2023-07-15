package com.masai.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.masai.Dao.EmployeeDao;
import com.masai.Exception.EmployeeException;
import com.masai.Utility.DBUtil;
import com.masai.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public String registerEmployee(Employee employee) {
		String msg = "Sucessfully Register";
		
		try(Connection con = DBUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setInt(1, employee.getEmpID());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getAddress());
			ps.setInt(4, employee.getSalary());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				return msg;
			}else {
				msg = "invalid Data Entry";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg = e.getMessage();
		}
		
		return msg;
	}

	public Employee getEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	public String giveBonusToEmployee(int empId, int amount) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

}
