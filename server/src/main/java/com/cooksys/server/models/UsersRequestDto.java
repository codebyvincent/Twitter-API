package com.cooksys.server.models;

import com.cooksys.server.models.data.UserData;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UsersRequestDto {

    private boolean admin;

    private UserData userData;
}
