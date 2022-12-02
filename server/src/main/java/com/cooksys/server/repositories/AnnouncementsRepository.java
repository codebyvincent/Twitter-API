package com.cooksys.server.repositories;

import com.cooksys.server.entities.Announcements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementsRepository extends JpaRepository<Announcements, Long> {

}
