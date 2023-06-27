package com.ciq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.entity.Department;
import com.ciq.entity.Project;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
