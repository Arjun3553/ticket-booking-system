package com.userprofile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userprofile.entity.UserProfileEntity;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {

	boolean existsByUserEmail(String userEmail);

	Optional<UserProfileEntity> findByUserEmail(String userEmail);

	void deleteByUserEmail(String userEmail);

}
