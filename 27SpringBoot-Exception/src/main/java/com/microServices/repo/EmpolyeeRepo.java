package com.microServices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microServices.model.Employee;

public interface EmpolyeeRepo extends JpaRepository<Employee, Integer> {

}
