package com.cooksys.server.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Projects {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private Boolean active;

    @ManyToOne
    private Team team;


}
