package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public UserDetailsService userDetailsServices() {
		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("user")).roles("USER")
				.build();
		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf((csrf) -> csrf.disable());
		http.authorizeHttpRequests((authorizeHttpRequests) -> {
			authorizeHttpRequests.antMatchers("/security").permitAll();
			authorizeHttpRequests.antMatchers("/pubilc").authenticated();
			authorizeHttpRequests.antMatchers("/user").hasRole("USER");
			authorizeHttpRequests.antMatchers("/admin").hasRole("ADMIN");

		});

		http.formLogin(Customizer.withDefaults());

		return http.build();
	}
}