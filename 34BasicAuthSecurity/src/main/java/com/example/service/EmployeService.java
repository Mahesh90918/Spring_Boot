package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeRepo;
import com.example.model.Employee;

@Service
public class EmployeService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee save(Employee employee) {
		String encode = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(encode);
		return employeeRepo.save(employee);
	}

	public Employee findByEid(Integer eid) {
		return employeeRepo.findById(eid).get();
	}

	public Employee findByUserName(String username) {
		// TODO Auto-generated method stub
		return employeeRepo.findByUserName(username);
	}
}
