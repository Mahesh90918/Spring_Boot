package com.mahesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mahesh.model.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {

	@Query(value = "select * from User_Info where user_Name=?1", nativeQuery = true)
	public UserInfo findByUserName(String name);
}