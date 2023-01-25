package com.example.demo.Empcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeConroller {

	@Autowired
	private EmployeeService empservice;

	@GetMapping("/findAll")
	public List<Employee> findAll() {
		return empservice.findAll();

	}

	
}
