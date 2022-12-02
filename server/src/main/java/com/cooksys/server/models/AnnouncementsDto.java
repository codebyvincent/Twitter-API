package com.cooksys.server.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
public class AnnouncementsDto {

    private Timestamp date;

    private String title;

    private String message;

    private String nameOfUser;

}
