package com.cooksys.server.controllers;

import java.util.List;

import com.cooksys.server.models.ProjectsDto;
import com.cooksys.server.services.ProjectsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectsController {

	private final ProjectsService projectsService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProjectsDto> getProjects() {
		return projectsService.getProjects();
	}

	@PatchMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public ProjectsDto updateProject(ProjectsDto projectsDto) {
		return projectsService.updateProject(projectsDto);
	}
}
