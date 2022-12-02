package com.cooksys.server.services.impl;

import java.util.List;

import com.cooksys.server.controllers.exceptions.NotAuthorizedException;
import com.cooksys.server.entities.Projects;
import com.cooksys.server.mappers.ProjectsMapper;
import com.cooksys.server.models.ProjectsDto;
import com.cooksys.server.repositories.ProjectsRepository;
import com.cooksys.server.services.ProjectsService;
import org.springframework.stereotype.Service;

import com.cooksys.server.controllers.exceptions.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectsService {

	private final ProjectsMapper projectsMapper;

	private final ProjectsRepository projectsRepository;

	private final TeamServiceImpl teamService;

	@Override
	public ProjectsDto updateProject(ProjectsDto projectsDto) {
		Projects projects = projectsRepository.findProjectsByName(projectsDto.getNameOfProject())
				.orElseThrow(() -> new NotFoundException("No project found with the provide data."));

		if (!projectsDto.isAdmin() || projectsDto.getTeamName() != projects.getTeam().getName())
			throw new NotAuthorizedException("Only admin or team members can update projects.");

		if (projectsDto.getProjectsData().getName() != null)
			projects.setName(projectsDto.getProjectsData().getName());
		if (projectsDto.getProjectsData().getDescription() != null)
			projects.setDescription(projectsDto.getProjectsData().getDescription());
		if (projectsDto.getProjectsData().getActive() != null)
			projects.setActive(projectsDto.getProjectsData().getActive());
		if (projectsDto.getProjectsData().getTeamName() != null)
			projects.setTeam(teamService.getValidTeam(projectsDto.getProjectsData().getTeamName()));

		return projectsMapper.entityToDto(projectsRepository.saveAndFlush(projects));
	}

	@Override
	public List<ProjectsDto> getProjects() {
		return projectsMapper.entitiesToDtos(projectsRepository.findAll());
	}
}
