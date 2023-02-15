package com.mahesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.model.Lab;

public interface LabRepo extends JpaRepository<Lab, Integer>{

}