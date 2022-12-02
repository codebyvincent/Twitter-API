package com.cooksys.server.models.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class TeamData {

    private String name;

    private String description;

    private String companyName;

}
