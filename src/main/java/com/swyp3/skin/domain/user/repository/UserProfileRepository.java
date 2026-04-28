package com.swyp3.skin.domain.user.repository;

import com.swyp3.skin.domain.user.domain.entity.User;
import com.swyp3.skin.domain.user.domain.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUser_Id(Long userId);

    Optional<UserProfile> findByUser(User user);
}
