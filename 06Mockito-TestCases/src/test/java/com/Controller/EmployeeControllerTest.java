package com.Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.Service.EmployeeService;
import com.bean.Employee;
import com.controller.EmployeeController;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController employeeController;

	private List<Employee> mockitoListData() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1011, "Siva", 32000, "Siva@gmail"));
		list.add(new Employee(1012, "Sriman", 32000, "Siva@gmail"));
		list.add(new Employee(1013, "Shan", 32000, "Siva@gmail"));
		list.add(new Employee(1014, "Mahesh", 32000, "Siva@gmail"));
		list.add(new Employee(1015, "Ravi", 32000, "Siva@gmail"));
		return list;

	}

	@Before
	public void init() {
		when(employeeService.findById(1001)).thenReturn(new Employee(1001, "Siva", 32000, "Siva@gmail"));
		when(employeeService.findById(1002)).thenReturn(new Employee(1002, "Shankar", 32000, "shankar@gmail"));
		when(employeeService.findById(1003)).thenReturn(new Employee(1003, "mahesh", 32000, "mahesh@gmail"));
		when(employeeService.findbyAll()).thenReturn(mockitoListData());
	}

	@Test
	public void ConnectionTest() {
		assertNotNull(employeeController);
		System.out.println(employeeService);
		System.out.println(employeeController);
	}

	@Test
	public void findByIdTest() {
		assertEquals("Siva", employeeController.findById(1001).getName());
	}

	@Test
	public void saveTest() {
		Employee emp = mockitoListData().get(0);
		employeeController.save(emp);
		// verification of employee DAO save method is working or Not
		verify(employeeService).save(emp);
		// And then how many Times repeat that method
		verify(employeeService, times(1)).save(emp);
	}

	@Test
	public void updateTest() {
		Employee emp = mockitoListData().get(0);
		employeeController.update(emp);
		verify(employeeService).update(emp);
		verify(employeeService, times(1)).update(emp);
	}

	@Test
	public void deleteTest() {
		employeeController.delete(1013);
		verify(employeeService, times(1)).delete(1013);
	}

	@Test
	public void findAllTest() {
		// Size test
		assertEquals(5, employeeController.findbyAll().size());

		List<Employee> list = employeeController.findbyAll();
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}
}
