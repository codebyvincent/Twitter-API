package com.cooksys.server.services;

import com.cooksys.server.models.TeamRequestDto;
import com.cooksys.server.models.TeamResponseDto;

import java.util.List;

public interface TeamService {
    TeamResponseDto updateTeam(TeamRequestDto teamRequestDto);

    TeamResponseDto deleteTeam(TeamRequestDto teamRequestDto);

    TeamResponseDto createTeam(TeamRequestDto teamRequestDto);

    List<TeamResponseDto> findTeamByValue(TeamRequestDto teamRequestDto);

}
