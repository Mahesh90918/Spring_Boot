package com.example.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Employee;

@RestController
public class DeleteMethodReading {

	@Autowired
	RestTemplate restTemplate;

	@DeleteMapping("emp/delete/{eid}")
	public String delete(@PathVariable Integer eid) {
		restTemplate.delete("http://localhost:9090/delete/" + eid);
		return "DELETE SUCCESSFULLY DeleteMethodReading";
	}
	@DeleteMapping("emp/delete1/{eid}")
	public String delete1(@PathVariable Integer eid) {
		restTemplate.delete("http://localhost:9090/delete/{eid}" , eid);
		return "DELETE SUCCESSFULLY DeleteMethodReading 1";
	}


}
