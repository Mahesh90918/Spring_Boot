package com.ciq.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.ciq.dto.DepartmentDto;
import com.ciq.entity.Department;

public interface DepartmentService {
	
	public Department save(DepartmentDto departmentDto);

	public List<Department> findAll();

	public Department findById(Long did);

}
