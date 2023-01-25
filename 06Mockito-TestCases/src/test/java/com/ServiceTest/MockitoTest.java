package com.ServiceTest;

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

import com.Service.EmployeeServiceImpl;
import com.bean.Employee;
import com.dao.EmployeeDao;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

	@Mock
	private EmployeeDao employeeDao;

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

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
		when(employeeDao.findById(1001)).thenReturn(new Employee(1001, "Siva", 32000, "Siva@gmail"));
		when(employeeDao.findById(1002)).thenReturn(new Employee(1002, "Shankar", 32000, "shankar@gmail"));
		when(employeeDao.findById(1003)).thenReturn(new Employee(1003, "mahesh", 32000, "mahesh@gmail"));
		when(employeeDao.findbyAll()).thenReturn(mockitoListData());
	}

	@Test
	public void ConnectionTest() {
		assertNotNull(employeeServiceImpl);
		System.out.println(employeeDao);
		System.out.println(employeeServiceImpl);
	}

	@Test
	public void findByIdTest() {
		assertEquals("Siva", employeeServiceImpl.findById(1001).getName());
	}

	@Test
	public void saveTest() {
		Employee emp = mockitoListData().get(0);
		employeeServiceImpl.save(emp);
		// verification of employee DAO save method is working or Not
		verify(employeeDao).save(emp);
		// And then how many Times repeat that method
		verify(employeeDao, times(1)).save(emp);
	}

	@Test
	public void updateTest() {
		Employee emp = mockitoListData().get(0);
		employeeServiceImpl.update(emp);
		verify(employeeDao).update(emp);
		verify(employeeDao, times(1)).update(emp);
	}

	@Test
	public void deleteTest() {
		employeeServiceImpl.delete(1013);
		verify(employeeDao, times(1)).delete(1013);
	}

	@Test
	public void findAllTest() {
		// Size test
		assertEquals(5, employeeServiceImpl.findbyAll().size());

		List<Employee> list = employeeServiceImpl.findbyAll();
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}
}
