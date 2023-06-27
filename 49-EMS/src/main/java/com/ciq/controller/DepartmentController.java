package com.ciq.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.dto.DepartmentDto;
import com.ciq.entity.Department;
import com.ciq.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<Department> save(@Valid @RequestBody DepartmentDto departmentDto) {
		return new ResponseEntity<Department>(departmentService.save(departmentDto), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Department> findAll() {
		return departmentService.findAll();
	}
	  
	@GetMapping("/{did}")
	public ResponseEntity<?> findById(@PathVariable("did") Long did) {
		Department department = departmentService.findById(did);
		if (department == null) {
			return new ResponseEntity<String>("Record not found with did : "+did, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}

}
