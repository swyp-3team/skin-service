package com.swyp3.skin.domain.user.repository;

import com.swyp3.skin.domain.user.domain.entity.UserOauth;
import com.swyp3.skin.global.auth.enums.AuthProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserOauthRepository extends JpaRepository<UserOauth, Long> {
    Optional<UserOauth> findByProviderAndProviderUserId(AuthProvider provider, String providerUserId);
}
