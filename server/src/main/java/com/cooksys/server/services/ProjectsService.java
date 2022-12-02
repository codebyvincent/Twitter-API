package com.cooksys.server.services;

import java.util.List;

import com.cooksys.server.models.ProjectsDto;

public interface ProjectsService {

	ProjectsDto updateProject(ProjectsDto projectsDto);

	List<ProjectsDto> getProjects();
}
