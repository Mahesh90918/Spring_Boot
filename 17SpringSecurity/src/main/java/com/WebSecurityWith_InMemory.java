package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

//This Is The older Version
public class WebSecurityWith_InMemory {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//		http.authorizeHttpRequests().antMatchers("/home").permitAll()
//				.antMatchers("/login/home").authenticated().antMatchers("/login/user")
//				.hasAuthority("ROLE_User").antMatchers("/login/admin").hasAuthority("ROLE_Admin")
//				.antMatchers("/login/home").hasAnyAuthority("ROLE_Admin", "ROLE_User").anyRequest().authenticated()
//				.and().formLogin().defaultSuccessUrl("/login/welcome", true).and().exceptionHandling()
//				.accessDeniedPage("/AccessDeied").and().logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		http.authorizeRequests().antMatchers("/swagger-ui/**").permitAll().anyRequest().authenticated().and()
				.httpBasic();

		return http.build();

	} 

//	@Bean
//	public UserDetailsService detailsService() {
//
//		UserDetails user1 = User.withDefaultPasswordEncoder().username("mahesh").password("mahesh").roles("User").build();
//
//		UserDetails user2 = User.withDefaultPasswordEncoder().username("siva").password("siva").roles("Admin").build();
//		return new InMemoryUserDetailsManager(user1, user2);
//	}

	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder().username("mahesh").password("mahesh").roles("User").build();
		UserDetails admin = User.builder().username("admin").password("mahesh").roles("User", "Admin").build();
		return new InMemoryUserDetailsManager(user, admin);
	}

}
