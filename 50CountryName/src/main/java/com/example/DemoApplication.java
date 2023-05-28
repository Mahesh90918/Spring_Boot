package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
//		
//		State s3=new State();
//		s3.setSname("ts");
//		Country c3=new Country();
//		c3.setCname("siva");
//		s3.setCountry(c3);
//		st.save(s3);

//		System.out.println(cs.findByStates("siva"));
		
//		List<Country> findAll = cr.findAll();
//
//		List<State> collect = findAll.stream().filter(t -> t.getCname().equals("siva"))
//				.flatMap(m -> m.getStates().stream()).collect(Collectors.toList());
//		System.out.println(collect);
		
		System.out.println(st.findByCountryCname("siva"));
		System.out.println("------------------------");
		System.out.println(st.findByCname("siva"));
		System.out.println("============================");
		System.out.println(st.getData());

	}

}
