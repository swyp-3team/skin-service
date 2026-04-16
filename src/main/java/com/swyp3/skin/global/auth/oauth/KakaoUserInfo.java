package com.swyp3.skin.global.auth.oauth;

import com.swyp3.skin.global.auth.exception.AuthErrorCode;
import com.swyp3.skin.global.auth.exception.AuthException;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class KakaoUserInfo implements OAuth2UserInfo{
    // 카카오는 중첩 구조라 훨씬 복잡함
    private final Map<String, Object> attributes;

    @Override
    public String getProviderUserId() {
        Object id = attributes.get("id");

        if (id == null) {
            throw new AuthException(AuthErrorCode.INVALID_OAUTH_USER_INFO);
        }
        return String.valueOf(id);
    }

    @Override
    public String getEmail() {
        Map<String, Object> kakaoAccount = getKakaoAccount();

        if (kakaoAccount == null) return null;

        return (String) kakaoAccount.get("email");
    }

    @Override
    public String getNickname() {
        Map<String, Object> profile = getKakaoProfile();

        if (profile == null) return null;

        return (String) profile.get("nickname");
    }

    @Override
    public String getProfileImageUrl() {
        Map<String, Object> profile = getKakaoProfile();

        if (profile == null) return null;

        return (String) profile.get("profile_image_url");
    }



    private Map<String,Object> getKakaoAccount() {
        return (Map<String, Object>) attributes.get("kakao_account");
    }

    private Map<String,Object> getKakaoProfile() {
        Map<String, Object> kakaoAccount = getKakaoAccount();
        if (kakaoAccount == null) return null;

        return (Map<String, Object>) kakaoAccount.get("profile");
    }
}
