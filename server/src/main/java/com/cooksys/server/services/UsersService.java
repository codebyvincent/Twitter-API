package com.cooksys.server.services;

import java.util.List;

import com.cooksys.server.models.UsersRequestDto;
import com.cooksys.server.models.UsersResponseDto;

public interface UsersService {

    UsersResponseDto createUser(UsersRequestDto usersRequestDto);

    List<UsersResponseDto> getAllUsers();

    List<UsersResponseDto> getUserByValue(UsersRequestDto usersRequestDto);

    UsersResponseDto updateUser(UsersRequestDto usersRequestDto);

    UsersResponseDto deleteUser(UsersRequestDto usersRequestDto);

    boolean logUserIn(UsersRequestDto usersRequestDto);
}
