package com.masai.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Employee;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin("*")
public class EmployeeService {

	Map<Integer, List<Employee>> empMap = new HashMap<>();

	@PostConstruct
	public void myInti() {
		List<Employee> emp1 = new ArrayList<>();
		emp1.add(new Employee(1, "Aman", "Maurya", "aman@gamil.com", "SDE-1"));
		empMap.put(1, emp1);
		List<Employee> emp2 = new ArrayList<>();
		emp2.add(new Employee(2, "Rounak", "Dhatterwal", "rounak@gamil.com", "SDE-1"));
		empMap.put(2, emp2);
		List<Employee> emp3 = new ArrayList<>();
		emp3.add(new Employee(3, "Rahul", "Chamoli", "rahul@gamil.com", "SDE-2"));
		empMap.put(3, emp3);

	}

	@PostMapping("/employees/{compId}")
	public ResponseEntity<String> postEmployee(@PathVariable Integer compId,
			@RequestBody(required = false) Employee emp) {
		boolean flag = true;

		for (Map.Entry<Integer, List<Employee>> set : empMap.entrySet()) {
			if (set.getKey() == compId) {
				set.getValue().add(emp);
				flag = false;
			}
		}

		if (flag) {
			empMap.put(compId, Arrays.asList(emp));
		}
		String res = "Sucessfully Added " + emp;
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	@PutMapping("/employees/{compId}")
	public ResponseEntity<String> putEmployee(@PathVariable Integer compId,
			@RequestBody(required = false) Employee emp) {
		boolean flag = true;

		for (Map.Entry<Integer, List<Employee>> set : empMap.entrySet()) {
			if (set.getKey() == compId) {
				for (Employee e : set.getValue()) {
					if (emp.getId() == e.getId()) {
						List<Employee> list = set.getValue();
						list.remove(e);
						list.add(emp);
						empMap.put(compId, list);
						flag = false;
						break;
					}
				}
				if (!flag)
					break;
			}
		}

		String res = "Sucessfully Update " + emp;
		if (flag) {
			return new ResponseEntity<>("Not Updated", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId) {
		boolean flag = true;
		for (Map.Entry<Integer, List<Employee>> set : empMap.entrySet()) {
			List<Employee> list = set.getValue();
			for (Employee e : list) {
				if (e.getId() == empId) {
					list.remove(e);
					empMap.put(set.getKey(), list);
					flag = false;
					break;
				}
			}

		}
		if (flag)
			return new ResponseEntity<>("Not Deleted", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>("Sucessfully Deleted", HttpStatus.OK);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {

		List<Employee> emp = new ArrayList<>();

		empMap.values().forEach(e -> e.forEach(e1 -> emp.add(e1)));

		return emp;
	}

	@GetMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable Integer empId) {

		for (Map.Entry<Integer, List<Employee>> set : empMap.entrySet()) {
			List<Employee> list = set.getValue();
			for (Employee e : list) {
				if (e.getId() == empId) {
					return e;
				}
			}
		}

		return null;
	}
}
