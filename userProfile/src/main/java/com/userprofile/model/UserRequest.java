package com.userprofile.model;

import java.time.LocalDate;

import com.userprofile.annotations.NumberValidations;
import com.userprofile.entity.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

	@NotNull(message = "username should not be blank")
	private String userName;

	@NotNull
	@Email
	private String userEmail;

	@NotNull
	@NumberValidations
	private Long userNumber;

	@NotNull
	@Min(value = 18)
	@Max(value = 64)
	private Integer userAge;

	@NotNull(message = "enter your gender")
	private String userGender;

	@NotNull(message = "enter your dob in the following format yyyy-mm-dd")
	private LocalDate userDOB;

	@NotNull
	private UserRole userRole;

	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,12}$", message = "enter a valid password")
	@Size(min = 8, max = 12)
	private String userPassword;
}
