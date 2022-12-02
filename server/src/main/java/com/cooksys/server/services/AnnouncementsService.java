package com.cooksys.server.services;

import com.cooksys.server.models.AnnouncementsDto;

import java.util.List;

public interface AnnouncementsService {

    List<AnnouncementsDto> getAnnouncements();

	AnnouncementsDto createAnnouncement(AnnouncementsDto announcementDto);

}
