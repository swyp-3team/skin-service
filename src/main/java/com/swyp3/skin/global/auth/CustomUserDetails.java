package com.swyp3.skin.global.auth;

import com.swyp3.skin.domain.user.domain.enums.UserRole;
import com.swyp3.skin.global.auth.enums.AuthProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public record CustomUserDetails (
        Long userId,
        UserRole role,
        String userName,
        AuthProvider provider,
        String email
)implements OAuth2User, UserDetails
{
    @Override
    public String getPassword() {
        return "";
    }
    @Override
    public String getUsername() {
        return String.valueOf(userId);
    }
    @Override
    public Map<String, Object> getAttributes() {
        return Map.of();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_" + role.name())
        );
    }
    @Override
    public String getName() {
        return String.valueOf(userId);
    }

}