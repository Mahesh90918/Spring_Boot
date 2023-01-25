package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> findAll() {
		List<Employee> employees=Arrays.asList(new Employee[] {
			new Employee(01, "Siva", 1234, "sdf@sdf")	,
			new Employee(02, "shankar", 123456, "sdf@sdf")	,
			new Employee(03, "mahesh", 6543, "sdf@sdf")	,
			new Employee(04, "Siva", 12365, "sdf@sdf")	,
		});
		return employees;
	}

}
