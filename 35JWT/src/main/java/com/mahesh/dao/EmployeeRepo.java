package com.mahesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	Employee findByUserName(String username);

}
