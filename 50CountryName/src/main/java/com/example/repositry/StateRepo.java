package com.example.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entity.State;

@EnableJpaRepositories
public interface StateRepo extends JpaRepository<State, Integer> {
	List<State> findByCountryCname(String name);
	
	List<State> findBySname(String name);
	
//	====================================================
	@Query(value = "select * from Country c join State s on c.cid=s.country_cid where c.cname=?1", nativeQuery = true)
	List<State> findByCname11(String country);
	@Query(value = "select * from Country c join State s on c.cid=s.country_cid where c.cname='siva'", nativeQuery = true)
	List<State> getData();
}
