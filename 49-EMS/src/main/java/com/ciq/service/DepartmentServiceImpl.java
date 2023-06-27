package com.ciq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciq.dto.DepartmentDto;
import com.ciq.entity.Department;
import com.ciq.exception.DepartmentNameNotFoundException;
import com.ciq.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department save(DepartmentDto departmentDto) {
		Department department = Department.builder().dlocation(departmentDto.getDlocation())
				.dname(departmentDto.getDname()).build();
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department findById(Long did) {
		Optional<Department> optional = departmentRepository.findById(did);
		if (optional.isEmpty()) {
			return null;
		}
		
		Department department = optional.get();
		
		if("".equals(department.getDname())) {
			throw new DepartmentNameNotFoundException("Department Name not found So it is invalid record ");
		}
		
		return optional.get();
	}

}
