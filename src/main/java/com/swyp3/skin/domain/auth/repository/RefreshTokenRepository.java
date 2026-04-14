package com.swyp3.skin.domain.auth.repository;

import com.swyp3.skin.domain.auth.domain.entity.RefreshToken;
import com.swyp3.skin.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByUser(User user);
    void deleteByToken(String token);
}
