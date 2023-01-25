package com.mahesh.restController;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mahesh.model.Employee;
import com.mahesh.service.EmployeeService;

@RestController
public class EmployeeRestController {

	Logger log = org.slf4j.LoggerFactory.getLogger(EmployeeRestController.class);
	@Autowired
	private EmployeeService empService;

	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		empService.save(employee);
		return employee;
	}

	@DeleteMapping("/delete/{eid}")
	public String delete(@PathVariable Integer eid) {
		empService.delete(eid);
		return "DELETE SUCCESSFULLY";
	}

	@PutMapping("/update")
	public Employee updateEmp(@RequestBody Employee employee) {
		empService.updateEmp(employee);
		return employee;
	}

	@GetMapping("/findById/{eid}")
	public Employee findById(@PathVariable Integer eid) {
		return empService.findById(eid);

	}

	@GetMapping("/findAll")
	public List<Employee> findAll() {
		return empService.findAll();

	}

}
