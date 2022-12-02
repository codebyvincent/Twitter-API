package com.cooksys.server.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UsersResponseDto {

    private String username;

    private String first;

    private String last;

    private String email;

    private String phone;

    private boolean active;

    private boolean admin;

    private String status;

    private String teamName;

    private String CompanyName;

}
