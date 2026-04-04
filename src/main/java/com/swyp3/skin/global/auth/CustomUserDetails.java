package com.swyp3.skin.global.auth;

import com.swyp3.skin.domain.user.domain.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Getter
public class CustomUserDetails implements OAuth2User {

    private final Long userId;
    private final String email;
    private final String role; // 1. Role을 미리 문자열로 받아둡니다.
    private final Map<String, Object> attributes;

    public CustomUserDetails(User user, String email, Map<String, Object> attributes) {
        this.userId = user.getId();
        this.email = email;
        this.role = user.getRole().name(); // 2. 생성 시점에 Role 이름을 확정 짓습니다.
        this.attributes = attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 3. 미리 받아둔 role 문자열을 사용하므로 DB 세션이 필요 없습니다.
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public String getName() {
        return String.valueOf(userId);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }
}