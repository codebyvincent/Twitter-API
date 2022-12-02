package com.cooksys.server.services.impl;

import com.cooksys.server.controllers.exceptions.BadRequestException;
import com.cooksys.server.controllers.exceptions.NotAuthorizedException;
import com.cooksys.server.controllers.exceptions.NotFoundException;
import com.cooksys.server.entities.Company;
import com.cooksys.server.mappers.TeamMapper;
import com.cooksys.server.models.TeamRequestDto;
import com.cooksys.server.models.TeamResponseDto;
import com.cooksys.server.models.data.TeamData;
import com.cooksys.server.repositories.TeamRepository;
import com.cooksys.server.services.TeamService;
import com.cooksys.server.entities.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    private final TeamMapper teamMapper;

    private final CompanyServiceImpl companyService;


    /**
     * FIND A TEAM
     **/


    @Override
    public List<TeamResponseDto> findTeamByValue(TeamRequestDto teamRequestDto) {
        TeamData data = teamRequestDto.getTeamData();
        List<Team> teamsByCompany = teamRepository.findTeamByCompany(companyService.getCompanyByName(data.getCompanyName()));
        if (teamsByCompany.isEmpty()) {
            throw new NotFoundException("This company doesn't have any teams yet!");
        } else return teamMapper.entitiesToDtos(teamsByCompany);
    }


    /**
     * UPDATE TEAM
     **/
    @Override
    public TeamResponseDto updateTeam(TeamRequestDto teamRequestDto) {
        validateTeamRequestDto(teamRequestDto);
        Team teamToUpdate = getValidTeam(teamRequestDto.getTeamName());
        TeamData data = teamRequestDto.getTeamData();

        if (data.getName() != null) teamToUpdate.setName(data.getName());
        if (data.getDescription() != null) teamToUpdate.setDescription(data.getDescription());
        //TODO: Update find by Id
        if (data.getCompanyName() != null) teamToUpdate.setCompany(companyService.getCompanyByName(data.getCompanyName()));

        return teamMapper.entityToDto(teamRepository.saveAndFlush(teamToUpdate));
    }

    /**
     * DELETE TEAM
     **/
    @Override
    public TeamResponseDto deleteTeam(TeamRequestDto teamRequestDto) {
        if (!teamRequestDto.isAdmin()) throw new NotAuthorizedException("A user must be an admin to delete a team.");
        getValidTeam(teamRequestDto.getTeamName());


        return teamMapper.entityToDto(teamRepository.deleteTeamByName(teamRequestDto.getTeamName()));

    }

    /**
     * CREATE TEAM
     **/
    @Override
    public TeamResponseDto createTeam(TeamRequestDto teamRequestDto) {

        //check if admin
        if (!teamRequestDto.isAdmin()) throw new NotAuthorizedException("A user must be an admin to create a team.");
        TeamData data = teamRequestDto.getTeamData();

        //check for required fields

        if (data.getName() == null) {
            throw new BadRequestException("Please enter a team name");
        }
        if (data.getCompanyName() == null) {
            throw new BadRequestException("Team must be associated with a Company");
        }
        if (data.getDescription() == null) {
            throw new BadRequestException("Please enter a team description");
        }
        //create the team

        Team newTeam = teamMapper.requestEntity(teamRequestDto);
        newTeam.setName(data.getName());
        newTeam.setDescription(data.getDescription());
        //find company and set team company
        Company findCompany = companyService.getCompanyByName(data.getCompanyName());
        newTeam.setCompany(findCompany);

        return teamMapper.entityToDto(teamRepository.saveAndFlush(newTeam));

    }

    protected Team getValidTeam(String name) {
        return teamRepository.findTeamByName(name).orElseThrow(() -> new NotFoundException("No team was found with the given name."));
    }

    private void validateTeamRequestDto(TeamRequestDto teamRequestDto) {
        if (!teamRequestDto.isAdmin()) throw new NotAuthorizedException("A user must be an admin to update a team.");
        if (teamRequestDto == null ||
                teamRequestDto.getTeamName() == null ||
                teamRequestDto.getTeamName().isBlank() ||
                teamRequestDto.getTeamData() == null ||
                teamRequestDto.getTeamData().getName() == null &&
                        teamRequestDto.getTeamData().getDescription() == null &&
                        teamRequestDto.getTeamData().getCompanyName() == null)
            throw new BadRequestException("When updating, at least one field must be valid.");
    }
}
