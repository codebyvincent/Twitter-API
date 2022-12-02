package com.cooksys.server.mappers;

import java.util.List;

import com.cooksys.server.models.UsersResponseDto;
import org.mapstruct.Mapper;

import com.cooksys.server.entities.Users;

@Mapper(componentModel = "spring")
public interface UsersMapper {

	UsersResponseDto entityToDto(Users users);

	List<UsersResponseDto> entitiesToDtos(List<Users> users);

	Users dtoToEntity(UsersResponseDto userResponseDto);

}
