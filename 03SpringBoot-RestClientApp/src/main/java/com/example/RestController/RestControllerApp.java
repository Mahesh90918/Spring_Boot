package com.example.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Employee;

@RestController
public class RestControllerApp {
	// GetMethod Reading Only

	@Autowired
	RestTemplate restTemplate;

	// call from Project 02SpringBoot-DAO
	// this is one way to read

	@GetMapping("/emp/findAll")
	public String callEmpFindAllService() {
		return restTemplate.getForObject("http://localhost:9090/findAll", String.class);

	}

	// this is SecondWay way to read
	@GetMapping("/emp/findAll1")
	public ResponseEntity<?> callEmpFindAllService1() {
		return restTemplate.getForEntity("http://localhost:9090/findAll", Employee[].class);

	}

	// this is Third way to read
	@GetMapping("/emp/findAll2")
	public Employee[] callEmpFindAllService2() {
		return restTemplate.getForObject("http://localhost:9090/findAll", Employee[].class);

	}

	// Rest Controller URI

	@GetMapping("/emp/rest/findAll")
	public ResponseEntity<?> callEmpFindAllService3() {
		return restTemplate.getForEntity("http://localhost:9090/rest/findAll1", Employee[].class);

	}

}
