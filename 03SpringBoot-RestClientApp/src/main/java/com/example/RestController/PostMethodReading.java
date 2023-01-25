package com.example.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Employee;

@RestController
public class PostMethodReading {
	@Autowired
	RestTemplate restTemplate;

	// post Sending data one Way
	@PostMapping("/emp/save")
	public ResponseEntity<?> callEmpSaveService(@RequestBody Employee employee) {
		restTemplate.postForEntity("http://localhost:9090/save", employee, String.class);

		return new ResponseEntity<>(HttpStatus.OK).ok("recored saved");

	}

	// post Sending data second Way
	@PostMapping("/emp/save1")
	public ResponseEntity<?> callEmpSaveService1(@RequestBody Employee employee) {

		return restTemplate.postForEntity("http://localhost:9090/save", employee, Employee.class);

	}

	// post Sending data Third Way
	@PostMapping("/emp/save2")
	public Employee callEmpSaveService2(@RequestBody Employee employee) {

		return restTemplate.postForObject("http://localhost:9090/save", employee, Employee.class);

	}
}
