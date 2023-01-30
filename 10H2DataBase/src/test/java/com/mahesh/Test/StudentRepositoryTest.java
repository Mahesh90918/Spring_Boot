package com.mahesh.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mahesh.bean.Student;
import com.mahesh.dao.StudentRepositry;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {

	@Autowired
	JpaRepository<Student, Integer> jpa;
	@Autowired
	StudentRepositry studentRepositry;

	@Test
	public void connectionTest() {
		assertNotNull(studentRepositry);
		System.out.println(studentRepositry);
	}

	@Test
	public void findAll() {
		List<Student> list = studentRepositry.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void save() {
		Student student = new Student(01, "SIVA", 43234, "hff@fdfd");
		Student list = studentRepositry.save(student);
		System.out.println(list);
	}

	@Test
	@Disabled
	public void delete() {

		studentRepositry.deleteById(9);
		verify(jpa).deleteById(9);
	}

	

}
