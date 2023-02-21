package com.mahesh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentController {

	@Value("${envName}")
	String env;
	
	@GetMapping("/envTest")
	public String envTest() {
		System.out.println("asdasd :"+env);
		return env;

	}
}
