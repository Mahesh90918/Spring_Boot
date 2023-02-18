package com.mahesh.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/home1")
	public String home() {
		return "Home Any One Can Access";

	}
	

	@GetMapping("/common")
	public String common() {
		return " Any One Can Access after login";

	}

	@GetMapping("/admin")
	public String admin() {
		return "Admin  Only Can Access";

	}

	@GetMapping("/user")
	public String user() {
		return "user only Can Access";

	}

	@GetMapping("/welcome")
	public String welcome() {
		return "After login Welcome page";

	}
	

	@GetMapping("/accessDenied")
	public String acc() {
		return "You dont have permission to access 403...!";

	}
}
