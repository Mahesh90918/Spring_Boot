package com.mahesh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.bean.Student;
import com.mahesh.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		// TODO Auto-generated method stub
		return studentService.save(student);
	}

	@PutMapping("/update")
	public Student update(@RequestBody Student student) {
		// TODO Auto-generated method stub
		return studentService.save(student);
	}

	@PostMapping("/SaveorUpdate")
	public Student saveorUpdate(@RequestBody Student student) {
		// TODO Auto-generated method stub
		return studentService.save(student);
	}

	@GetMapping("/findById/{sid}")
	public Student FindById(@PathVariable Integer sid) {
		// TODO Auto-generated method stub
		return studentService.FindById(sid);
	}

	@GetMapping("/findById1/{sid}")
	public Optional<Student> FindById1(@PathVariable Integer sid) {
		// TODO Auto-generated method stub
		return studentService.FindById1(sid);
	}

	@DeleteMapping("/delete/{sid}")
	public String delete(@PathVariable Integer sid) {
		// TODO Auto-generated method stub
		studentService.delete(sid);
		return "Delete Student Successfully";
	}

	@DeleteMapping("/deleteById/{sid}")
	public String deleteById(@PathVariable Integer sid) {
		studentService.deleteById(sid);
		return "DeleteById Student Successfully";
	}

	@GetMapping("/findAll")
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentService.findAll();
	}

}
