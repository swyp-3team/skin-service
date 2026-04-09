package com.swyp3.skin.global.auth;

import com.swyp3.skin.domain.user.domain.entity.User;
import com.swyp3.skin.domain.user.domain.entity.UserOauth;
import com.swyp3.skin.domain.user.domain.entity.UserProfile;
import com.swyp3.skin.domain.user.domain.enums.UserRole;
import com.swyp3.skin.domain.user.domain.repository.UserOauthRepository;
import com.swyp3.skin.domain.user.domain.repository.UserProfileRepository;
import com.swyp3.skin.domain.user.domain.repository.UserRepository;
import com.swyp3.skin.global.auth.enums.AuthProvider;
import com.swyp3.skin.global.auth.exception.AuthErrorCode;
import com.swyp3.skin.global.auth.exception.AuthException;
import java.util.Map;
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

    private final UserRepository userRepository;
    private final UserOauthRepository userOauthRepository;
    private final UserProfileRepository userProfileRepository;

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        String providerUserId = ""; // 고유 식별자
        String email = null;
        String profileImageUrl = null;

        //데이터 추출 분기 처리
        if ("google".equals(registrationId)) {
            providerUserId = String.valueOf(attributes.get("sub"));
            email = (String) attributes.get("email");
            profileImageUrl = (String) attributes.get("picture");
        } else if ("kakao".equals(registrationId)) {
            providerUserId = String.valueOf(attributes.get("id"));
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");

            if (kakaoAccount != null) {
                email = (String) kakaoAccount.get("email");
            }
            if (properties != null) {
                profileImageUrl = (String) properties.get("profile_image");
            }
        }

        // null처리
        if (providerUserId == null || providerUserId.isBlank()) {
            throw new AuthException(AuthErrorCode.INVALID_PROVIDER);
        }

        log.info("[{}] 로그인 시도 - providerId: {}, email: {}", registrationId, providerUserId, email);

        final String finalEmail = email;
        final String finalProfileImageUrl = profileImageUrl;
        final String finalProviderUserId = providerUserId;

        AuthProvider authProvider = AuthProvider.from(registrationId);
        return userOauthRepository.findByProviderAndProviderUserId(authProvider, finalProviderUserId)
                // 기존 유저인 경우 (CustomUserDetails의 생성자도 간소화했다고 가정)
                .map(oauth -> new CustomUserDetails(oauth.getUser(), attributes))
                .orElseGet(() -> {

                    User user = userRepository.save(User.create(UserRole.USER));

                    // 2. UserOauth 연동 정보 저장 (Builder 대신 정적 팩토리 메서드)
                    userOauthRepository.save(UserOauth.create(
                            user,
                            authProvider,
                            finalProviderUserId,
                            finalEmail
                    ));

                    // 3. UserProfile 정보 저장 (UserProfile 엔티티도 create 메서드를 만들었다고 가정)
                    userProfileRepository.save(UserProfile.create(
                            user,
                            finalProfileImageUrl
                    ));

                    return new CustomUserDetails(user, attributes);

                });
    }
}


