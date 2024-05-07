package com.userprofile.model;

import java.time.LocalDate;

import com.userprofile.entity.UserProfileEntity;
import com.userprofile.entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

	private Long userId;
	private String userName;
	private String userEmail;
	private Long userNumber;
	private Integer userAge;
	private String userGender;
	private LocalDate userDOB;
	private UserRole userRole;
	private String userPassword;

	public UserResponse(UserProfileEntity entity) {
		this.userId = entity.getUserId();
		this.userName = entity.getUserName();
		this.userEmail = entity.getUserEmail();
		this.userNumber = entity.getUserNumber();
		this.userAge = entity.getUserAge();
		this.userGender = entity.getUserGender();
		this.userDOB = entity.getUserDOB();
		this.userRole = entity.getUserRole();
		this.userPassword = entity.getUserPassword();
	}
}
