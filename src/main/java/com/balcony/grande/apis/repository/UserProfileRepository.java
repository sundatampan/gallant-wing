package com.balcony.grande.apis.repository;

import com.balcony.grande.apis.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    UserProfile findByUserId(UUID userId);
}
