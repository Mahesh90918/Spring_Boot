package com.mahesh.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class MyScheduler {

	@Scheduled(fixedRate = 5000)
	public void myscheldular() {
		System.out.println("myscheldular MSG");
	}
	
	
	@Scheduled(cron = "* * * ? * *")
	public void cron() {
		System.out.println("spring boot scheduler cron example MSG");
	}
}
