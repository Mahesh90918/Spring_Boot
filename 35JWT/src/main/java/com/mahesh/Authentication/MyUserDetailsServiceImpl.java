package com.mahesh.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mahesh.model.Employee;
import com.mahesh.service.EmployeService;

@Service
@Transactional
public class MyUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeService employeService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp = employeService.findByUserName(username);
		return new MyUserDetails(emp);
	}

}
