package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeService;

@RestController
public class ControllerTest {

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
	@GetMapping("/home")
	public String home() {
		return "HOME";
	}
	@GetMapping("/hello1")
	public String hello1() {
		return "Hello 1";
	}
	@GetMapping("/hello2")
	public String hello2() {
		return "Hello 2";
	}
	@GetMapping("/hello3")
	public String hello3() {
		return "Hello 3";
	}

	@PostMapping("/saveEmp")
	public Employee saveEmp(@RequestBody Employee employee) {
		System.out.println(employee);
		return employeService.save(employee);
	}
}
