package com.cooksys.server.controllers;

import com.cooksys.server.models.UsersRequestDto;
import com.cooksys.server.models.UsersResponseDto;
import com.cooksys.server.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/echo")
    @ResponseStatus(HttpStatus.OK)
    public String echo() {
        return "End point hit.";
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public UsersResponseDto createUser(@RequestBody UsersRequestDto usersRequestDto) {
        return usersService.createUser(usersRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsersResponseDto> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public List<UsersResponseDto> getUserByValue(UsersRequestDto usersRequestDto) {
        return usersService.getUserByValue(usersRequestDto);
    }

    @PatchMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UsersResponseDto updateUser(UsersRequestDto usersRequestDto) {
        return usersService.updateUser(usersRequestDto);
    }

    @DeleteMapping("delete")
    @ResponseStatus(HttpStatus.OK)
    public UsersResponseDto deleteUser(UsersRequestDto usersRequestDto) {
        return usersService.deleteUser(usersRequestDto);
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public boolean loginUserIn(UsersRequestDto usersRequestDto) {
        return usersService.logUserIn(usersRequestDto);
    }
}
