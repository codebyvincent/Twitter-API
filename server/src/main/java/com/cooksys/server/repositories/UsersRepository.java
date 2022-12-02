package com.cooksys.server.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.server.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Optional<Users> findUsersByUsername(String username);

	List<Users> findUsersByActive(boolean active);

	List<Users> findUsersByIsAdmin(boolean admin);

	List<Users> findUsersByTeam_Name(String name);

	List<Users> findUsersByCompany_Name(String name);

	boolean existsUsersByUsernameAndPasswordAndActiveIsTrue(String username, String password);

}
