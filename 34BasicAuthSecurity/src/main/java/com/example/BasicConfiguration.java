package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.Authentication.MyUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class BasicConfiguration {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MyUserDetailsServiceImpl userDetails;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf((csrf) -> csrf.disable());
		http.authorizeHttpRequests((authorizeHttpRequests) -> {
			authorizeHttpRequests.antMatchers("/home", "/saveEmp").permitAll();
			authorizeHttpRequests.antMatchers("/hello").authenticated();
			authorizeHttpRequests.antMatchers("/hello1","hello3").hasRole("USER");
			authorizeHttpRequests.antMatchers("/hello2","hello3").hasRole("ADMIN");
		});
//  http.httpBasic();
		http.formLogin();

		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder);
	}
	

}
