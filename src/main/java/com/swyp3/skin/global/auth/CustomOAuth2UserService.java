package com.swyp3.skin.global.auth;

import com.swyp3.skin.domain.user.domain.entity.User;
import com.swyp3.skin.domain.user.domain.entity.UserOauth;
import com.swyp3.skin.domain.user.domain.entity.UserProfile;
import com.swyp3.skin.domain.user.domain.enums.AuthProvider;
import com.swyp3.skin.domain.user.domain.enums.UserRole;
import com.swyp3.skin.domain.user.domain.repository.UserOauthRepository;
import com.swyp3.skin.domain.user.domain.repository.UserProfileRepository;
import com.swyp3.skin.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final UserOauthRepository userOauthRepository;
    private final UserProfileRepository userProfileRepository;

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String provider = registrationId.toUpperCase();
        String providerUserId = oAuth2User.getName(); // 고유 식별자

        String email = "no-email@temporary.com"; // email NULL 값 방지
        String profileImageUrl = "";

        //데이터 추출 분기 처리
        if ("google".equals(registrationId)) {
            email = (String) attributes.getOrDefault("email", email);
            profileImageUrl = (String) attributes.get("picture");
        } else if ("kakao".equals(registrationId)) {
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");

            if (kakaoAccount != null) {
                String kakaoEmail = (String) kakaoAccount.get("email");
                if(kakaoEmail != null) email = kakaoEmail;
            }
            if (properties != null) {
                profileImageUrl = (String) properties.get("profile_image");
            }
        }

        log.info("[{}] 로그인 시도 - providerId: {}, email: {}", provider, providerUserId, email);

        final String finalEmail = email;
        final String finalProfileImageUrl = profileImageUrl;

        return userOauthRepository.findByProviderAndProviderUserId(AuthProvider.valueOf(provider), providerUserId)
                .map(oauth -> new CustomUserDetails(oauth.getUser(), finalEmail, attributes))
                .orElseGet(() -> {
                    // 신규 가입 로직
                    User user = userRepository.save(User.builder()
                            .role(UserRole.USER)
                            .build());

                    userOauthRepository.save(UserOauth.builder()
                            .user(user)
                            .provider(AuthProvider.valueOf(provider))
                            .providerUserId(providerUserId)
                            .email(finalEmail)
                            .build());

                    userProfileRepository.save(UserProfile.builder()
                            .user(user)
                            .nickname("SkinUser_" + user.getId())
                            .profileImageUrl(finalProfileImageUrl) // 분기 처리된 이미지 경로 사용
                            .build());

                    return new CustomUserDetails(user, finalEmail, attributes);
                });
    }
    }
