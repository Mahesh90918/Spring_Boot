package com.mahesh.restControllerMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.model.ResponseEntityExample;
import com.mahesh.service.EmployeeService;

@RestController
public class EmployeeRestControllerMessage {

	@Autowired
	private EmployeeService empService;

//       Status Message if file not founded
	@GetMapping("/rest/findAll1")
	public ResponseEntity<?> findAll1() {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(empService.findAll());
		} catch (Exception e) {
			return new ResponseEntity("Data Not Founded", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/rest/findAll2")
	public ResponseEntityExample findAll2() {
		try {
			return new ResponseEntityExample(200, empService.findAll());
		} catch (Exception e) {
			return new ResponseEntityExample(404, "CUSTOMIZED MEASSAGE Data Not Found");
		}

	}

	@GetMapping("/rest/findById1/{id}")
	public ResponseEntityExample getByid(@PathVariable Integer id) {

		try {
			return new ResponseEntityExample(200, empService.findById(id));
		} catch (Exception e) {
			return new ResponseEntityExample(404, "CUSTOMIZED MEASSAGE Record Not Found");
		}

	}

	@GetMapping("/rest/findById2/{eid}")
	public ResponseEntity<?> findById1(@PathVariable Integer eid) {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(empService.findById(eid));
		} catch (Exception e) {
			return new ResponseEntity("FILE NOT FOUNDED", HttpStatus.NOT_FOUND);
		}
	}

}
