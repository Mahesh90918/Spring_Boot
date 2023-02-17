package com.mahesh.Controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mahesh.MailUtil.MailSendUtil;

@Controller
public class MailController {
	
	@Autowired
	MailSendUtil mailSendUtil;

	@GetMapping("/sentMail")
	public @ResponseBody String SendMailMsg( @RequestBody @RequestParam("gmail") String sentMail) {
		return mailSendUtil.senderMail(sentMail);
	}
	@GetMapping("/hii")
	public  @ResponseBody String Hiii() {
		return "HIIII";
	}
	
}
