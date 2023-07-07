package com.example;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entity.Country;
import com.example.entity.State;
import com.example.repositry.CountryRepo;
import com.example.repositry.StateRepo;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	CountryRepo cr;
	@Autowired
	StateRepo st;
	

	@Override
	public void run(String... args) throws Exception {

//		Country c=new Country();
//		c.setCname("mahesh");
//		
//		State s1=new State();
//		s1.setSname("Ap");
//		State s2=new State();
//		s2.setSname("Ap1");
//		c.setStates(Arrays.asList(s1,s2));
//		cr.save(c);
		
//		State s3=new State();
//		s3.setSname("karnataka");
//		Country c3=new Country();
//		c3.setCname("mahesh");
//		s3.setCountry(c3);
//		st.save(s3);
//		
//		State s4=new State();
//		s4.setSname("bangulore");
//		Country c4=new Country();
//		c4.setCname("siva");
//		s4.setCountry(c4);
//		st.save(s4);
//		


//		states
//		List<State> li = st.findBySname("ap");
//		System.out.println(li);
//		
//		List<State> li1=st.findByCountryCname("mahesh");
//		System.out.println(li1);
		
//		List<State> lid = st.findByCname11("siva");
//		System.out.println(lid);
//		List<State> lid1 = st.getData();
//		System.out.println(lid1);
		
		
//		 countries
//		List<Country> f = cr.findByCname("mahesh");
//		System.out.println(f);
		
//		List<Country> f1 = cr.findByCname11("siva");
//		System.out.println(f1);
//		List<Country> f2 = cr.findByCname11("mahesh");
//		System.out.println(f2);
		
//		List<Country> f3 = cr.getData();
//		System.out.println(f3);
		
		

	}

}
