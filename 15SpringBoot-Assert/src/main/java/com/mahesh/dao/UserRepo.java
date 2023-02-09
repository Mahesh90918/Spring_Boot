package com.mahesh.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.model.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {

}