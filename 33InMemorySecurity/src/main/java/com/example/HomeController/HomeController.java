package com.example.HomeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/security")
	public String get() {
		return "security enabled";
	}

	@GetMapping("/pubilc")
	public String pubilc() {
		return "pubilc";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

}
