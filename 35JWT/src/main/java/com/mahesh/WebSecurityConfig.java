package com.mahesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mahesh.Authentication.MyUserDetailsServiceImpl;
import com.mahesh.jwt.JwtAuthenticationEntryPoint;
import com.mahesh.jwt.JwtRequestFilter;

@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	
	@Autowired
	MyUserDetailsServiceImpl userDetails;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.authorizeHttpRequests().antMatchers("/hello", "/authenticate").permitAll()
				.antMatchers("/v3/api-docs/**", "/configuration/ui", "/swagger-resources/**", "/configuration/security",
						"/swagger-ui/**", "/webjars/**")
				.permitAll().antMatchers("/saveEmp").hasAuthority("mahesh").and().exceptionHandling()
				.authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();

	}

	@Bean
	public AuthenticationManager manager(HttpSecurity http, BCryptPasswordEncoder encode, MyUserDetailsServiceImpl user)
			throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(user).passwordEncoder(encode)
				.and().build();

	}

}
