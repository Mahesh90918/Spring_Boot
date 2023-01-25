package com.example.demo.Hellocontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldConroller {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";

	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";

	}
}
