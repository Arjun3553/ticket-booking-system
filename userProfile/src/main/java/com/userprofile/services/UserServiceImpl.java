package com.userprofile.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.userprofile.entity.UserProfileEntity;
import com.userprofile.exceptions.UserException;
import com.userprofile.model.UserRequest;
import com.userprofile.model.UserResponse;
import com.userprofile.repository.UserProfileRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInterface {

	private Function<UserProfileEntity, UserResponse> userProfileEntityToUserResponse = (user) -> new UserResponse(
			user);

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public ResponseEntity<?> createUser(UserRequest userRequest) throws UserException {

		if (userProfileRepository.existsByUserEmail(userRequest.getUserEmail())) {
			throw new UserException("record already exist in database", HttpStatus.CONFLICT);
		}

		else {
			UserProfileEntity userProfileEntity = UserProfileEntity.builder().userName(userRequest.getUserName())
					.userEmail(userRequest.getUserEmail()).userNumber(userRequest.getUserNumber())
					.userAge(calculateAge(userRequest)).userGender(userRequest.getUserGender())
					.userDOB(userRequest.getUserDOB()).userRole(userRequest.getUserRole())
					.userPassword(userRequest.getUserPassword()).build();

			userProfileRepository.save(userProfileEntity);
			return new ResponseEntity<>("account created successfully", HttpStatus.ACCEPTED);
		}

	}

	@Override
	public ResponseEntity<?> readUser(String userEmail) throws UserException {
		if (userProfileRepository.existsByUserEmail(userEmail)) {
			UserProfileEntity userProfileEntity = userProfileRepository.findByUserEmail(userEmail).get();
			UserResponse userResponse = new UserResponse(userProfileEntity);

			return new ResponseEntity<>(userResponse, HttpStatus.OK);
		} else {
			throw new UserException("no record exist in database", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<?>> readAllUsers() throws UserException {

		if (userProfileRepository.findAll().isEmpty()) {
			throw new UserException("no record exist in database", HttpStatus.NOT_FOUND);
		} else {
			List<UserProfileEntity> userProfileEntities = userProfileRepository.findAll();
			List<UserResponse> userList = userProfileEntities.stream().map(userProfileEntityToUserResponse)
					.collect(Collectors.toList());

			return new ResponseEntity<>(userList, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<?> updateUser(String userEmail, UserRequest userRequest) throws UserException {
		if (userProfileRepository.existsByUserEmail(userEmail)) {
			UserProfileEntity userProfileEntity = userProfileRepository.findByUserEmail(userEmail).get();
			userProfileEntity.setUserDOB(userRequest.getUserDOB());
			userProfileEntity.setUserGender(userRequest.getUserGender());
			userProfileEntity.setUserPassword(userRequest.getUserPassword());
			userProfileRepository.save(userProfileEntity);

			return new ResponseEntity<>("account details updated successfully", HttpStatus.ACCEPTED);

		} else {
			throw new UserException("no record exist in database", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> deleteUser(String userEmail) throws UserException {
		if (userProfileRepository.existsByUserEmail(userEmail)) {

			userProfileRepository.deleteByUserEmail(userEmail);

			return new ResponseEntity<>("account deleted successfully", HttpStatus.ACCEPTED);
		} else {
			throw new UserException("no record exist in database", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Integer calculateAge(UserRequest userRequest) {

		LocalDate userDOB = userRequest.getUserDOB();
		LocalDate currentDate = LocalDate.now();

		int age = Period.between(userDOB, currentDate).getYears();

		return age;
	}

}
