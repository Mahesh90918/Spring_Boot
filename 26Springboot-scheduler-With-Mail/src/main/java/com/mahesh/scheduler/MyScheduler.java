package com.mahesh.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.MailUtil.MailSendUtil;

@RestController
public class MyScheduler {

	@Autowired
	MailSendUtil mailSendUtil;


	@GetMapping("/send")
	public String mailSchedular() {
		
		return mailSendUtil.senderMail();
	}
}
