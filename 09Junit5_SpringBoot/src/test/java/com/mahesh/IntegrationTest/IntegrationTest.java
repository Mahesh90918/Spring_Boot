package com.mahesh.IntegrationTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.mahesh.ControllerWithMSG.StudentWithMessageController;
import com.mahesh.bean.Student;

@SpringBootTest
public class IntegrationTest {

	@Autowired
	StudentWithMessageController studentWithMessageController;

	@Test
	public void ConnectionTest() {
		assertNotNull(studentWithMessageController);
		System.out.println(studentWithMessageController);
	}

	@Test
	@Disabled
	public void findAllWithOutData() {
		ResponseEntity<?> responseEntity = studentWithMessageController.findAll();
		List<Student> list = (List<Student>) responseEntity.getBody();
		assertThat(list, empty());
	}

	@Test
	@Disabled
	public void add() {
		Student student = new Student();
		student.setSname("Siva");
		student.setSfee(12345);
		student.setEmail("abc@gdsh");
		studentWithMessageController.save(student);
		assertThat(student, hasProperty("sname", equalTo("Siva")));
	}

	@Test
	public void delete() {
		studentWithMessageController.deleteById(3);

	}

	@Test
	public void update() {
		Student student = new Student();
		student.setSid(2);
		student.setSname("mahesh");
		student.setSfee(12345);
		student.setEmail("abc@gdsh");
		studentWithMessageController.update(student);
		assertThat(student, equalTo(student));
	}

	@Test
	public void findAllWithData() {
		ResponseEntity<?> responseEntity = studentWithMessageController.findAll();
		List<Student> list = (List<Student>) responseEntity.getBody();
//		assertThat(list, hasSize(2));
		assertThat(list, not(empty()));
		assertThat(list, hasItem(hasProperty("sname", equalTo("mahesh"))));
		System.out.println(list);

	}

	@Test
	public void findById() {
		ResponseEntity<?> responseEntity = studentWithMessageController.FindById(2);
		Student s1 = (Student) responseEntity.getBody();
		System.out.println(s1);
		assertThat(s1, hasProperty("sname", equalTo("mahesh")));
	}

	@Test
	public void findById1() {
		Student s1 = (Student) studentWithMessageController.FindById(2).getBody();
		System.out.println(s1);
		assertThat(s1, hasProperty("sname", equalTo("mahesh")));
	}

	@Test
	public void testCreateReadDelete() {
		Student Student = new Student(0, "Lokesh", 123455, "Gupta@hs");

		Student StudentResult = (Student) studentWithMessageController.save(Student).getBody();

		List<Student> Students = (List<Student>) studentWithMessageController.findAll().getBody();
		assertThat(Students, hasItem(hasProperty("sname", equalTo("mahesh"))));

		studentWithMessageController.delete(StudentResult.getSid());
		assertThat(Students, not(empty()));
	}
}
