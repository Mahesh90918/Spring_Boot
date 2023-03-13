package com.microServices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microServices.model.Employee;
import com.microServices.repo.EmpolyeeRepo;

@Service
public class EmpolyeeServiceImpl implements EmpolyeeService {

	@Autowired
	EmpolyeeRepo repo;

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

}
