package com.cooksys.server.mappers;

import com.cooksys.server.models.TeamRequestDto;
import com.cooksys.server.models.TeamResponseDto;
import com.cooksys.server.entities.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {CompanyMapper.class}, componentModel = "spring")
public interface TeamMapper {

    @Mapping(target = "companyName", source = "company.name")
    TeamResponseDto entityToDto(Team team);

    List<TeamResponseDto> entitiesToDtos(List<Team> team);

    @Mapping(target = "name", source = "teamData.name")
    @Mapping(target = "description", source = "teamData.description")
    @Mapping(target = "company", source = "teamData")
    Team requestEntity(TeamRequestDto teamRequestDto);

}
