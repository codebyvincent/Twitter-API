package com.cooksys.server.models;

import com.cooksys.server.models.data.TeamData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class TeamRequestDto {

    private boolean admin;

    private String teamName;

    @Embedded
    private TeamData teamData;

}
