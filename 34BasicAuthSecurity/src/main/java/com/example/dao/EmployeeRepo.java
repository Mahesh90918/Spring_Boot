package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	Employee findByUserName(String username);

}
