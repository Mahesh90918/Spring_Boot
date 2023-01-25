package com.example.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Employee;

@RestController
public class PutMethodReading {
	
	@Autowired
	RestTemplate restTemplate;

	@PutMapping("/emp/update")
	public Employee callEmpUpdateService(@RequestBody Employee employee) {
		 restTemplate.put("http://localhost:9090/update",employee,Employee.class);
		 return employee;
	}
	
	

}
