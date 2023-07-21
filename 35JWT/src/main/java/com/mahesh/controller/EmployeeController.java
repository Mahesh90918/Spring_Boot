package com.mahesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.model.Employee;
import com.mahesh.service.EmployeService;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeService employeService;
	
	@GetMapping("/{eid}")
	public Employee findByEmp(@PathVariable("eid") Integer eid) {
		return employeService.findByEid(eid);
	}
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@PostMapping("/saveEmp")
	public Employee saveEmp(@RequestBody Employee employee) {
		System.out.println(employee);
		return employeService.save(employee);
	}
}
