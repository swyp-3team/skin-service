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
        // 1. 소셜 유저 정보 가져오기
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();

        // 2. 서비스 제공자(GOOGLE/KAKAO) 및 이메일 추출 로직 추가
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String provider = registrationId.toUpperCase();
        String providerUserId = oAuth2User.getName();

        String email = "";
        if ("google".equals(registrationId)) {
            email = (String) attributes.get("email");
        } else if ("kakao".equals(registrationId)) {
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            if (kakaoAccount != null) {
                email = (String) kakaoAccount.get("email");
            }
        }
        log.info("[{}] 로그인 시도 - 이메일: {}, 아이디: {}", provider, email, providerUserId);

        // 3. 기존 소셜 가입 여부 확인 (email 파라미터 추가)
        final String finalEmail = email;
        return userOauthRepository.findByProviderAndProviderUserId(AuthProvider.valueOf(provider), providerUserId)
                .map(oauth -> new CustomUserDetails(oauth.getUser(), finalEmail, attributes))
                .orElseGet(() -> {
                    // 4. 신규 유저 가입 처리

                    // (1) User 엔티티 생성
                    User user = userRepository.save(User.builder()
                            .role(UserRole.USER)
                            .build());

                    // (2) 소셜 연동 정보 저장
                    userOauthRepository.save(UserOauth.builder()
                            .user(user)
                            .provider(AuthProvider.valueOf(provider))
                            .providerUserId(providerUserId)
                            .email(finalEmail)
                            .build());

                    // (3) 프로필 정보 저장
                    userProfileRepository.save(UserProfile.builder()
                            .user(user)
                            .nickname("SkinUser_" + user.getId())
                            .profileImageUrl((String) attributes.get("picture")) // 카카오는 'properties.profile_image' 등 경로가 다를 수 있음
                            .build());

                    return new CustomUserDetails(user, finalEmail, attributes);
                });
    }
}