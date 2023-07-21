package com.mahesh.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mahesh.model.UserInfo;
import com.mahesh.service.UserService;

@Service
@Transactional
public class MyUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService user;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfo userInfo=	user.findByUserName(username);
//		userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
		return new MyUserDetails(userInfo);
	}

}
