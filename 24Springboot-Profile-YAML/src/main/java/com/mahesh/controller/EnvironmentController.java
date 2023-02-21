package com.mahesh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentController {

	@Value("${envMsg}")
	String envdev;

	@GetMapping("/dev")
	public String envDev() {
		return envdev;
	}
}
