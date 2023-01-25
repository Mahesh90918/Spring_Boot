package com.mahesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.dao.EmployeeDao;
import com.mahesh.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public void save(Employee employee) {
		dao.save(employee);

	}

	@Override
	public void delete(Integer eid) {
		dao.delete(eid);

	}

	@Override
	public void updateEmp(Employee employee) {
		dao.updateEmp(employee);

	}

	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return dao.findById(eid);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
