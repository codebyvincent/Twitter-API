package com.cooksys.server.repositories;

import com.cooksys.server.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {

    Optional<Projects> findProjectsByName(String name);

}
