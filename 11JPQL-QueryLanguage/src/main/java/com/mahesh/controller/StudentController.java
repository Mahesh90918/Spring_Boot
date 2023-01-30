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

	@GetMapping("/findAll")
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentService.findAll();
	}

	// =====================================JPQL JAVA PERSISTENCE QUERY
	// LANGUAGE================================

	@GetMapping("/name/{sname}")
	public List<Student> findBysname(@PathVariable("sname") String sname) {
		// TODO Auto-generated method stub
		return studentService.findBySname(sname);
	}

	@GetMapping("/name1/{sname}/{sfee}")
	public List<Student> findBySnameAndSfee(@PathVariable("sname") String sname, @PathVariable("sfee") double sfee) {
		// TODO Auto-generated method stub
		return studentService.findBySnameAndSfee(sname, sfee);
	}

	@GetMapping("/name2/{sname}/{sfee}")
	public List<Student> findBySnameOrSfee(@PathVariable("sname") String sname, @PathVariable("sfee") double sfee) {
		// TODO Auto-generated method stub
		return studentService.findBySnameOrSfee(sname, sfee);
	}

	// ---normal Query----
	@GetMapping("/normal/{sname}")
	public List<Student> findBysname1(@PathVariable("sname") String sname) {
		// TODO Auto-generated method stub
		return studentService.findBySname1(sname);
	}

	@GetMapping("/normal1/{sname}/{sfee}")
	public List<Student> findBySnameAndSfee1(@PathVariable("sname") String sname, @PathVariable("sfee") double sfee) {
		// TODO Auto-generated method stub
		return studentService.findBySnameAndSfee1(sname, sfee);
	}

	@GetMapping("/normal2/{sname}/{sfee}")
	public List<Student> findBySnameOrSfee1(@PathVariable("sname") String sname, @PathVariable("sfee") double sfee) {
		// TODO Auto-generated method stub
		return studentService.findBySnameOrSfee1(sname, sfee);
	}

}
