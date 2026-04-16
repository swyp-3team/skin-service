package com.swyp3.skin.global.auth;

import com.swyp3.skin.domain.user.domain.entity.User;
import com.swyp3.skin.domain.user.domain.entity.UserOauth;
import com.swyp3.skin.domain.user.domain.entity.UserProfile;
import com.swyp3.skin.domain.user.domain.enums.UserRole;
import com.swyp3.skin.domain.user.repository.UserOauthRepository;
import com.swyp3.skin.domain.user.repository.UserProfileRepository;
import com.swyp3.skin.domain.user.repository.UserRepository;
import com.swyp3.skin.domain.user.service.UserService;
import com.swyp3.skin.global.auth.enums.AuthProvider;
import com.swyp3.skin.global.auth.exception.AuthErrorCode;
import com.swyp3.skin.global.auth.exception.AuthException;
import java.util.Map;

import com.swyp3.skin.global.auth.oauth.OAuth2UserInfo;
import com.swyp3.skin.global.auth.oauth.OAuth2UserInfoFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserService userService;

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        AuthProvider provider = AuthProvider.from(registrationId);
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.of(registrationId, attributes);
        User user = userService.findOrCreateUser(userInfo, provider);

        return new CustomUserDetails(
                user.getId(),
                user.getRole(),
                userInfo.getNickname(),
                provider,
                userInfo.getEmail()
        );
    }
}


