package com.ServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Service.EmployeeService;
import com.bean.Employee;

public class EmployeeServiceTest {

	private EmployeeService employeeService = null;

	@Before
	public void init() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringTest.xml");
		employeeService = (EmployeeService) ac.getBean("employeeServiceImpl");
	}

	@Test
	public void ConnectionTest() {
		assertNotNull(employeeService);
	}

	@Test
	public void saveTest() {
		Employee emp = new Employee(16, "siva", 12345, "Siva@");
		employeeService.save(emp);
	}

	@Test
	public void updateTest() {
		Employee emp = new Employee(21, "siva1", 12345, "Siva@");
		employeeService.update(emp);
	}

	@Test
	public void deleteTest() {
		employeeService.delete(29);
	}

	public void findByIdTest() {
		Employee emp = employeeService.findById(18);
		assertEquals(3, emp.getId());
		assertEquals("siva", emp.getName());
	}

	@Test
	public void findAllTest() {
		List<Employee> list = employeeService.findbyAll();
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}
}
