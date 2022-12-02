package com.cooksys.server.mappers;

import java.util.List;

import com.cooksys.server.entities.Projects;
import com.cooksys.server.models.ProjectsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectsMapper {

	@Mapping(target = "projectsData.name", source = "name")
	ProjectsDto entityToDto(Projects projects);
  
	List<ProjectsDto> entitiesToDtos(List<Projects> projects);

}
