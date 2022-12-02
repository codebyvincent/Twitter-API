package com.cooksys.server.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Users {

	@Id
	@GeneratedValue
	private Long id;

	private String username;

	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private Boolean active;

	private Boolean isAdmin;

	private String status;

	@ManyToOne
	private Team team;

	@ManyToOne
	private Company company;

}
