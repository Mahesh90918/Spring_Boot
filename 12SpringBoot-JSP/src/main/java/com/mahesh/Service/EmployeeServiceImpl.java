package com.mahesh.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.dao.EmployeeRepositry;
import com.mahesh.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepositry employeeRepositry;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepositry.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeeRepositry.save(employee);

	}

	@Override
	public void update(Employee employee) {
		employeeRepositry.save(employee);

	}

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepositry.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		employeeRepositry.deleteById(id);

	}
	

}
