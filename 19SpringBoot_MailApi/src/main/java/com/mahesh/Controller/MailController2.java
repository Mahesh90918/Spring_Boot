package com.mahesh.Controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String SendMailMsg(@RequestParam("gmail") String sentMail) {
		return mailSendUtil.senderMail(sentMail);
	}

	@GetMapping("/hii1")
	public String Hiii() {
		return "HIIII";
	}

	@GetMapping("/sent2/{sentMail}")
	public String SendMailMsg2(@PathVariable String sentMail) {
		System.out.println("Sent2" + sentMail);
		return mailSendUtil.senderMail(sentMail);
	}

	@GetMapping("/sent3")
	public String SendMailMsg1(@PathParam("gmail") String gmail) {
		System.out.println("Sent1" + gmail);
		return mailSendUtil.senderMail(gmail);
	}

}
