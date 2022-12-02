package com.cooksys.server.models.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class ProjectsData {

    private String name;

    private String description;

    private Boolean active;

    private String teamName;

}
