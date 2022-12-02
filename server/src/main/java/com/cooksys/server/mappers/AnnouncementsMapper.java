package com.cooksys.server.mappers;

import com.cooksys.server.models.AnnouncementsDto;
import com.cooksys.server.entities.Announcements;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnnouncementsMapper {

    List<AnnouncementsDto> entitiesToDtos(List<Announcements> announcements);

    @Mapping(source = "nameOfUser", target = "author.firstName")
    Announcements dtoToEntity(AnnouncementsDto announcementDto);

    @Mapping(source = "author.firstName", target = "nameOfUser")
    AnnouncementsDto entityToDto(Announcements announcement);
}

