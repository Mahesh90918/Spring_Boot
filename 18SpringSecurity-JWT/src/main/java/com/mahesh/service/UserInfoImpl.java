package com.mahesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mahesh.dao.UserRepo;
import com.mahesh.model.UserInfo;
@Service
public class UserInfoImpl implements UserService{

	@Autowired
	UserRepo repo;
	
	@Override
	public void addUser(UserInfo info) {
		info.setPassword(new BCryptPasswordEncoder().encode(info.getPassword()));
		repo.save(info);
		
	}

	@Override
	public List<UserInfo> getAllUsers() {
	
		return repo.findAll();
	}

	@Override
	public UserInfo getById(Integer id) {
	
		return repo.findById(id).get();
	}

	@Override
	public void deleteUser(Integer id) {
	repo.deleteById(id);
		
	}

	@Override
	public void updateUser(UserInfo user) {
	repo.save(user);
		
	}

	@Override
	public UserInfo findByUserName(String name) {
		// TODO Auto-generated method stub
		return repo.findByUserName(name);
	}

}
