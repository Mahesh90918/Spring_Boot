package com.ciq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.dto.DepartmentDto;
import com.ciq.dto.EmployeeDto;
import com.ciq.dto.ProjectDto;
import com.ciq.entity.Employee;
import com.ciq.entity.Project;
import com.ciq.service.EmployeeService;
import com.ciq.service.ProjectService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public Employee save(@RequestBody EmployeeDto employeeDto) {
		return employeeService.save(employeeDto);
	}

	@GetMapping
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

}
