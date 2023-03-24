package com.mahesh.Service;

import java.util.List;

import com.mahesh.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	void save(Employee employee);

	void update(Employee employee);

	Employee findById(Integer id);

	void deleteById(Integer id);
}
