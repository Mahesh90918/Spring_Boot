package com.ciq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciq.dto.EmployeeDto;
import com.ciq.entity.Department;
import com.ciq.entity.Employee;
import com.ciq.entity.Project;
import com.ciq.repository.DepartmentRepository;
import com.ciq.repository.EmployeeRepository;
import com.ciq.repository.ProjectRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Employee save(EmployeeDto employeeDto) {

		Department department = departmentRepository.findById(employeeDto.getDid()).get();
		List<Project> projects = projectRepository.findAllById(employeeDto.getPids());
		Employee employee = Employee.builder().ename(employeeDto.getEname()).esal(employeeDto.getEsal())
				.department(department).projects(projects).build();

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
