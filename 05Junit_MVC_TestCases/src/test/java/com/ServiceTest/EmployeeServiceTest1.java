package com.ServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Service.EmployeeService;
import com.bean.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/SpringTest.xml")
public class EmployeeServiceTest1 {
	
   @Autowired
	private EmployeeService employeeService;

//	 With Out ApplicationContext
//	@Before
//	public void init() {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringTest.xml");
//		employeeService = (EmployeeService) ac.getBean("employeeServiceImpl");
//	}

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
		Employee emp = new Employee(17, "siva1", 12345, "Siva@");
		employeeService.update(emp);
	}

	@Test
	public void deleteTest() {
		employeeService.delete(16);
	}

	public void findByIdTest() {
		Employee emp = employeeService.findById(17);
		assertEquals(17, emp.getId());
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
