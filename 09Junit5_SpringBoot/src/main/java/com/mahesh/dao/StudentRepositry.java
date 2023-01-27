package com.mahesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.bean.Student;

public interface StudentRepositry extends JpaRepository<Student, Integer> {

}
