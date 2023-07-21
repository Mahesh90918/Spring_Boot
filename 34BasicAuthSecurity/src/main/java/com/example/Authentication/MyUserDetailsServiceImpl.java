package com.example.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Employee;
import com.example.service.EmployeService;

@Service

public class MyUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeService employeService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee empBean = employeService.findByUserName(username);
		if (empBean == null) {
			throw new UsernameNotFoundException("Invalid Username or Password");
		}
		UserDetails userDetails = User.builder().username(empBean.getUserName()).password(empBean.getPassword())
				.roles(empBean.getRoles()).build();
		return userDetails;
	}

}
