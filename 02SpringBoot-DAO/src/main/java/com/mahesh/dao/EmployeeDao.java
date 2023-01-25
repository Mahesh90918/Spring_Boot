package com.mahesh.dao;

import java.util.List;

import com.mahesh.model.Employee;

public interface EmployeeDao {

	void save(Employee employee);

	void delete(Integer eid);

	void updateEmp(Employee employee);

	Employee findById(Integer eid);

	List<Employee> findAll();
}
