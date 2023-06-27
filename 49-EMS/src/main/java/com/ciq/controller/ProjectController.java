package com.ciq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.dto.DepartmentDto;
import com.ciq.dto.ProjectDto;
import com.ciq.entity.Project;
import com.ciq.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping
	public Project save(@RequestBody ProjectDto projectDto) {
		return projectService.save(projectDto);
	}

	@GetMapping
	public List<Project> findAll() {
		return projectService.findAll();
	}

}
