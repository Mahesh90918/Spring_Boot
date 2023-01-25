package com.daoTest;

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
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.bean.Employee;
import com.dao.EmployeeHibernateTempleteDaoImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDaoTest {

	@Mock
	private HibernateTemplate hbmTem;

	@InjectMocks
	private EmployeeHibernateTempleteDaoImpl employeeDao;

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
		when(hbmTem.get(Employee.class, 1001)).thenReturn(new Employee(1001, "Siva", 32000, "Siva@gmail"));
		when(hbmTem.loadAll(Employee.class)).thenReturn(mockitoListData());
	}

	@Test
	public void ConnectionTest() {
		assertNotNull(employeeDao);
		System.out.println(hbmTem);
		System.out.println(employeeDao);
	}

	@Test
	public void findByIdTest() {
		assertEquals("Siva", employeeDao.findById(1001).getName());
	}

	@Test
	public void saveTest() {
		Employee emp = mockitoListData().get(0);
		employeeDao.save(emp);
		// verification of employee DAO save method is working or Not
		verify(hbmTem).save(emp);
		// And then how many Times repeat that method
		verify(hbmTem, times(1)).save(emp);
	}

	@Test
	public void updateTest() {
		Employee emp = mockitoListData().get(0);
		employeeDao.update(emp);
		verify(hbmTem).update(emp);
		verify(hbmTem, times(1)).update(emp);
	}

	@Test
	public void deleteTest() {
		Employee emp = new Employee();
		emp.setId(1011);
		emp.setName("asd");
		emp.setSalary(1234);
		emp.setEmail("qwert2sd");
		emp.getSalary();
		emp.getEmail();
		Integer id = mockitoListData().get(0).getId();
		employeeDao.delete(id);

//		verify(hbmTem, times(1)).delete(emp);
	}

	@Test
	public void findAllTest() {
		// Size test
		assertEquals(5, employeeDao.findbyAll().size());

		List<Employee> list = employeeDao.findbyAll();
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}
}
