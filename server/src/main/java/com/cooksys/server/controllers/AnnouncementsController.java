package com.cooksys.server.controllers;

import com.cooksys.server.models.AnnouncementsDto;
import com.cooksys.server.services.AnnouncementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/announcements")
public class AnnouncementsController {

    private final AnnouncementsService announcementsService;

    @GetMapping

    public List<AnnouncementsDto> getAnnouncements() {
        return announcementsService.getAnnouncements();
    }
    
    @PostMapping
    public AnnouncementsDto createAnnouncement(@RequestBody AnnouncementsDto announcementDto) {
    	return announcementsService.createAnnouncement(announcementDto);
    }
}
