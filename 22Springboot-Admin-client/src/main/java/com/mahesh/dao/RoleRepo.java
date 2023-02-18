package com.mahesh.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}