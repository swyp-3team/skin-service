package com.swyp3.skin.global.auth.oauth;

public interface OAuth2UserInfo {
        String getProviderUserId(); // OAuth2 공급자에서 제공하는 고유 사용자 ID
        String getEmail(); // 사용자 이메일
        String getNickname(); // 사용자 이름
        String getProfileImageUrl(); // 사용자 프로필 이미지 URL
}
