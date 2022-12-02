package com.cooksys.server.models.data;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserData {

	private String username;

	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private Boolean active;

	private Boolean admin;

	private String status;

	private String teamName;

	private String companyName;

}
