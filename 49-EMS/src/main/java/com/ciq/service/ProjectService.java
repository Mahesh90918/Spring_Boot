package com.ciq.service;

import java.util.List;

import com.ciq.dto.ProjectDto;
import com.ciq.entity.Project;

public interface ProjectService {

	public Project save(ProjectDto projectDto);

	public List<Project> findAll();

}
