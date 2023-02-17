package com.mahesh.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.MailUtil.MailSendUtil;

@RestController
public class MailController2 {
	
	@Autowired
	MailSendUtil mailSendUtil;

	@GetMapping("/sentMail1")
	public  String SendMailMsg(@RequestParam("gmail") String sentMail) {
		return mailSendUtil.senderMail(sentMail);
	}
	@GetMapping("/hii1")
	public  String Hiii() {
		return "HIIII";
	}
//	@GetMapping("/sentMail1/{sentMail}")
//	public  String SendMailMsg1(@PathParam("sentMail") String sentMail) {
//		return mailSendUtil.senderMail(sentMail);
//	}
}
