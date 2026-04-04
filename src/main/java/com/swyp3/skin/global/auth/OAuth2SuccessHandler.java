package com.swyp3.skin.global.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // 1. 유저 정보 가져오기
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Long userId = userDetails.getUserId();
        String email = userDetails.getEmail(); // CustomUserDetails에 구현된 메서드 사용

        log.info("로그인 성공! 유저 ID: {}, 이메일: {}", userId, email);

        // 2. JWT 토큰 발급 (아직 Provider가 없으므로 임시 토큰 사용)
        String accessToken = "mock-access-token-12345";

        // 3. 리다이렉트 주소 설정 (백엔드 8080 스웨거로)
        String targetUrl = UriComponentsBuilder.fromUriString("http://localhost:8080/swagger-ui/index.html")
                .queryParam("accessToken", accessToken)
                .build().toUriString();

        // 4. 실제로 이동시키기
        response.sendRedirect(targetUrl);
    }
}