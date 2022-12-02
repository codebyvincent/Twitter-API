package com.cooksys.server.models;

import com.cooksys.server.models.data.ProjectsData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;

@NoArgsConstructor
@Getter
@Setter
public class ProjectsDto {

    private boolean admin;

    private String teamName;

    private String nameOfProject;

    @Embedded
    private ProjectsData projectsData;

}
