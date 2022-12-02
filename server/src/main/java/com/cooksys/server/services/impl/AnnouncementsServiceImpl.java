package com.cooksys.server.services.impl;

import com.cooksys.server.controllers.exceptions.BadRequestException;
import com.cooksys.server.entities.Announcements;
import com.cooksys.server.mappers.AnnouncementsMapper;
import com.cooksys.server.mappers.UsersMapper;
import com.cooksys.server.models.AnnouncementsDto;
import com.cooksys.server.repositories.AnnouncementsRepository;
import com.cooksys.server.services.AnnouncementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementsServiceImpl implements AnnouncementsService {

    private final AnnouncementsRepository announcementsRepository;

    private final AnnouncementsMapper announcementsMapper;

	private final UsersServiceImpl usersService;

    @Override
    public List<AnnouncementsDto> getAnnouncements() {
        return announcementsMapper.entitiesToDtos(announcementsRepository.findAll());
    }

	@Override
	public AnnouncementsDto createAnnouncement(AnnouncementsDto announcementDto) {
			validateAnnouncement(announcementDto);
//			should stop logic if errors are thrown ^
			Announcements announcementMade = announcementsMapper.dtoToEntity(announcementDto);
			announcementMade.setDate(Timestamp.valueOf(LocalDateTime.now()));
			announcementMade.setTitle(announcementDto.getTitle());
			announcementMade.setMessage(announcementDto.getMessage());
			announcementMade.setAuthor(usersService.getValidUser(announcementDto.getNameOfUser()));
			return announcementsMapper.entityToDto(announcementsRepository.saveAndFlush(announcementMade));
	}
	
	public boolean validateAnnouncement(AnnouncementsDto announcementDto) {
		String title = announcementDto.getTitle();
		String message = announcementDto.getMessage();
		if(message.isEmpty() || message == null) {
			throw new BadRequestException("Please fill out announcement message and title before submitting.");
		}
		if(title.isEmpty() || title == null) {
			throw new BadRequestException("Please fill out announcement message and title before submitting.");
		}
		return true;
	}
}
