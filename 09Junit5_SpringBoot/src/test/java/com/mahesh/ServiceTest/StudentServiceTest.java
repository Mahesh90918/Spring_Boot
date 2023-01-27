package com.mahesh.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mahesh.bean.Student;
import com.mahesh.dao.StudentRepositry;
import com.mahesh.service.StudentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

	@Mock
	private static StudentRepositry studentRepositry;

	@InjectMocks
	private StudentServiceImpl studentServiceImpl;

	@Test
	public void ConnectionTest() {
		assertNotNull(studentServiceImpl);
		System.out.println(studentRepositry);
		System.out.println(studentServiceImpl);
	}

	public List<Student> StudentList() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(01, "Siva", 10200, "Siva@123"));
		students.add(new Student(02, "shankar", 20000, "Siva@123"));
		students.add(new Student(03, "mahesh", 50000, "Siva@123"));
		students.add(new Student(04, "samba", 100000, "Siva@123"));
		return students;

	}

	@Test
	public void findByIdTest() {
		Student ss = new Student(1, "Lokesh", 1343, "user@email.com");

		when(studentRepositry.findById(1)).thenReturn(Optional.of(ss));

		Student emp = studentServiceImpl.FindById(1);

		assertEquals("Lokesh", emp.getSname());
		assertEquals("user@email.com", emp.getEmail());
	}

	@Test
	public void saveTest() {
		Student emp = new Student(01, "Subbu", 12345, "dfg@dfg");
		studentServiceImpl.save(emp);
		verify(studentRepositry).save(emp);
		verify(studentRepositry, times(1)).save(emp);
	}

//	@Test
//	public void updateTest() {
//		Student emp = StudentList().get(0);
//		studentServiceImpl.update(emp);
//		verify(studentRepositry).save(emp);
//		verify(studentRepositry, times(1)).save(emp);
//	}

	@Test
	public void deleteTest() {
		studentServiceImpl.deleteById(1);
		verify(studentRepositry, times(1)).deleteById(1);
	}

	@Test
	public void findAllTest() {
		// Size test
		assertEquals(0, studentServiceImpl.findAll().size());

		List<Student> list = studentServiceImpl.findAll();
		for (Student emp : list) {
			System.out.println(emp);
		}
	}
}
