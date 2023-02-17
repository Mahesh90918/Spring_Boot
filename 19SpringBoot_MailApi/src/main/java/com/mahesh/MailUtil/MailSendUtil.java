package com.mahesh.MailUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSendUtil {
	@Autowired
	JavaMailSender javaMailSender;

	@Value("/${spring.mail.username}")
	private String sender;

	public String senderMail(String receiver) {
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(sender);
			simpleMailMessage.setTo(receiver);
			simpleMailMessage.setText("Hi I am  Send Msg For You");
			simpleMailMessage.setSubject("My Name is Mahesh");
			javaMailSender.send(simpleMailMessage);
			return "Mail Sent Successfully";
		} catch (Exception e) {
			// TODO: handle exception
			return "Mail Not Sent Successfully";
		}
	}

}
