package com.example.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entity.Country;

@EnableJpaRepositories
public interface CountryRepo extends JpaRepository<Country, Integer> {
	


}
