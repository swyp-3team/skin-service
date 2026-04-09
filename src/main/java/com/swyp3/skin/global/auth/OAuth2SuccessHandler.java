package com.swyp3.skin.global.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider; // 주입 추가

    private final RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // 1. 유저 정보 가져오기
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Long userId = userDetails.getUserId();

        log.info("로그인 성공! JWT 발급 시작. 유저 ID: {}", userId);
        //2. JWT 토큰 발급
        String accessToken = jwtTokenProvider.createAccessToken(userId);

        String targetUrl = "https://api.layerd.co.kr/";

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest != null) {
            targetUrl = savedRequest.getRedirectUrl();
            requestCache.removeRequest(request, response);
            log.info("원래 가려던 목적지로 리다이렉트 합니다: {}", targetUrl);
        } else {
            log.info("원래 목적지가 없어 기본 목적지(스웨거)로 리다이렉트 합니다.");
        }

        // 3. 리다이렉트 주소 설정
        String redirectUrl = UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("accessToken", accessToken)
                .build().toUriString();

        response.sendRedirect(redirectUrl);
    }
}