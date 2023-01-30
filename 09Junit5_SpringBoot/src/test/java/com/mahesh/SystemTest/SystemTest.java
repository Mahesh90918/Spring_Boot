package com.mahesh.SystemTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mahesh.bean.Student;

public class SystemTest {

	@Test
	@Disabled
	public void testCreateReadDelete() {
		RestTemplate restTemplate = new RestTemplate();

		String saveUrl = "http://localhost:9099/stu/save";
		String findAllUrl = "http://localhost:9099/rest/stu/findAll";
		String deleteUrl = "http://localhost:9099/stu/delete";

		Student Student = new Student(01, "Mahesh", 1234.00, "M@m");
		ResponseEntity<Student> entity = restTemplate.postForEntity(saveUrl, Student, Student.class);

		Student[] Students = restTemplate.getForObject(findAllUrl, Student[].class);
		assertThat(Students, equalTo(Students));

//		restTemplate.delete(deleteUrl + "/" + entity.getBody().getSid());

	}
}
