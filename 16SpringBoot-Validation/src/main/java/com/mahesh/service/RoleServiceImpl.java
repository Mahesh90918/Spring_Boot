package com.mahesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.dao.RoleRepo;
import com.mahesh.model.Role;

@Service
public class RoleServiceImpl implements Roles{

	@Autowired 
	RoleRepo repo;
	
	@Override
	public void save(Role role) {
		repo.save(role);
		

	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public void update(Role role) {
		repo.save(role);
		
	}

	@Override
	public Role getByRoleID(Integer id) {
	return repo.findById(id).get();
		
	}

	@Override
	public List<Role> getAllRoles() {
		
		return repo.findAll();
	}

}
