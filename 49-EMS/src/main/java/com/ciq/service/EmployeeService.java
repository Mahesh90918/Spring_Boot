package com.ciq.service;

import java.util.List;

import com.ciq.dto.EmployeeDto;
import com.ciq.entity.Employee;
import com.ciq.entity.Project;

public interface EmployeeService {

	public Employee save(EmployeeDto employeeDto);

	public List<Employee> findAll();

}
