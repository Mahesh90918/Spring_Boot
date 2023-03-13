package com.microServices.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microServices.ExceptionClass.EmployeeNotFoundException;
import com.microServices.model.Employee;
import com.microServices.repo.EmpolyeeRepo;
import com.microServices.service.EmpolyeeService;

@RestController
public class ExceptionController {

	@Autowired
	EmpolyeeRepo repo;

	@Autowired
	EmpolyeeService ser;

	@PostConstruct
	public List<Employee> data() {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(01, "siva", 123456, "serdtfgyhj"));
		list.add(new Employee(02, "mahesh", 123456, "serdtfgyhj"));
		list.add(new Employee(03, "mahesh", 123456, "serdtfgyhj"));
		return repo.saveAll(list);
	}

	@GetMapping("/hi")
	public ResponseEntity<?> mah() {
		throw new EmployeeNotFoundException("Employee Not Founded this");
	}

	@GetMapping("/exp/{id}")
	public ResponseEntity<?> msgNotFound(@PathVariable("id") Integer id) {

		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(ser.findById(id));
		} catch (Exception e) {
//			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR).ok(new EmployeeNotFoundException("Not found Employee"));
			 throw new EmployeeNotFoundException("Not found Employee   :"+id);
		}

	}

	@GetMapping("/e/{sid}")
	public ResponseEntity<?> FindById(@PathVariable Integer sid) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(ser.findById(sid));
		} catch (Exception e) {
			return new ResponseEntity<>("FindById Student Not Founded"+sid, HttpStatus.NOT_FOUND);
		}
	}

}
