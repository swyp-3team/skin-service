package com.swyp3.skin.global.auth;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class CustomUserDetails implements OAuth2User, UserDetails {

    private final Long userId;
    private final String role;
    private final Map<String, Object> attributes;

    public CustomUserDetails(Long userId, String role, Map<String, Object> attributes) {
        this.userId = userId;
        this.role = role;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return String.valueOf(userId);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_" + role)
        );
    }

    @Override public String getPassword() { return null; }
    @Override public String getUsername() { return String.valueOf(userId); }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    public Long getUserId() { return userId; }
    public String getRole() { return role; }
}