package com.mahesh.ControllerWithMSG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class StudentWithMessageController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/stu/save")
	public ResponseEntity<?> save(@RequestBody Student student) {
		try {
			return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(" Student Data Not Saved", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/stu/update")
	public ResponseEntity<?> update(@RequestBody Student student) {
		try {
			return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Student update Id Not Available", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/stu/SaveorUpdate")
	public ResponseEntity<?> saveorUpdate(@RequestBody Student student) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(" Student Data Not Saved", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/stu/findById/{sid}")
	public ResponseEntity<?> FindById(@PathVariable Integer sid) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>( HttpStatus.OK).ok(studentService.FindById(sid));
		} catch (Exception e) {
			return new ResponseEntity<>("FindById Student Not Founded", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/stu/findById1/{sid}")
	public  ResponseEntity<?> FindById1(@PathVariable Integer sid) {
		// MSG Not Working
		try {
			return new ResponseEntity<>(studentService.FindById1(sid),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("FindById1 Student Not Founded", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/stu/delete/{sid}")
	public ResponseEntity<?> delete(@PathVariable Integer sid) {
		// MSG Not Working
		try {
			studentService.delete(sid);
			return new ResponseEntity<>("Delete Student Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("DeleteById Student Not Founded", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/stu/deleteById/{sid}")
	public ResponseEntity<?> deleteById(@PathVariable Integer sid) {
		try {
			studentService.deleteById(sid);
			return new ResponseEntity<>("DeleteById Student Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("DeleteById Student Not Founded", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/stu/findAll")
	public ResponseEntity<?> findAll() {
		try {
			return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Data Not Founded", HttpStatus.BAD_REQUEST);
		}
	}
}
