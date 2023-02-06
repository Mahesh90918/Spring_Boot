package com.mahesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.model.Employee;

public interface EmployeeRepositry extends JpaRepository<Employee, Integer>{

}
