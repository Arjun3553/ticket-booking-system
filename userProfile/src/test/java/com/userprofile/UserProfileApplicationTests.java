package com.userprofile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.userprofile.repository.UserProfileRepository;
import com.userprofile.services.UserServiceInterface;

@SpringBootTest
class UserProfileApplicationTests {

	@Autowired
	private UserServiceInterface userServiceImpl;

	@MockBean
	private UserProfileRepository repository;

	@Test
	public void createUserTest() {

	}

}
