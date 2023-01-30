package com.mahesh.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.mahesh.ControllerWithMSG.StudentWithMessageController;
import com.mahesh.bean.Student;
import com.mahesh.service.StudentService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentWithMessageController.class)
public class StudentControllerMocKTest {

	@MockBean
	StudentService studentService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testfindAll() throws Exception {
		Student s1 = new Student(01, "Mahesh", 1234.00, "M@m");
		Student s2 = new Student(02, "Siva", 1234.00, "M@m");
		List<Student> ss = Arrays.asList(s1, s2);

		Mockito.when(studentService.findAll()).thenReturn(ss);
		// $ means All
		// $[0] means First Student
		// $[1] means Second Student

		mockMvc.perform(get("/rest/stu/findAll")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(2))).andExpect(jsonPath("$[0].sid", Matchers.is(01)))
				.andExpect(jsonPath("$[0].sname", Matchers.is("Mahesh")))
				.andExpect(jsonPath("$[0].sfee", Matchers.is(1234.00))).andExpect(jsonPath("$[1].sid", Matchers.is(02)))
				.andExpect(jsonPath("$[1].sname", Matchers.is("Siva")))
				.andExpect(jsonPath("$[1].sfee", Matchers.is(1234.00)));
	}

	@Test
	public void testfindById() throws Exception {
		Student s1 = new Student(01, "Mahesh", 1234.00, "M@m");

		Mockito.when(studentService.FindById(1)).thenReturn(s1);

		mockMvc.perform(get("/stu/findById/1")).andExpect(status().isOk()).andExpect(jsonPath("$.sid", Matchers.is(01)))
				.andExpect(jsonPath("$.sname", Matchers.is("Mahesh")))
				.andExpect(jsonPath("$.sfee", Matchers.is(1234.00)));
	}

	@Test
	public void deleteById() throws Exception {
		Student s1 = new Student(01, "Mahesh", 1234.00, "M@m");
		studentService.deleteById(1);

		mockMvc.perform(delete("/stu/deleteById/" + s1.getSid())).andExpect(status().isOk());
	}

	@Test
	public void save() throws Exception {
		Student s1 = new Student(05, "Mahesh", 1234.00, "M@m");

		Mockito.when(studentService.save(s1)).thenReturn(s1);

		mockMvc.perform(post("/stu/save"));
	}

	@Test
	public void saveorUpdate() throws Exception {
		Student s1 = new Student(05, "Mahesh", 1234.00, "M@m");

		Mockito.when(studentService.save(s1)).thenReturn(s1);

		mockMvc.perform(post("/stu/SaveorUpdate"));
	}

	@Test
	public void update() throws Exception {
		Student s1 = new Student(05, "Mahesh", 1234.00, "M@m");

		Mockito.when(studentService.save(s1)).thenReturn(s1);

		mockMvc.perform(put("/stu/update"));
	}
}
