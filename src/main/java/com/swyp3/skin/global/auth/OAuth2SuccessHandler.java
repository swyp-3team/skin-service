package com.swyp3.skin.global.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Value("${app.cookie.secure:false}")
    private boolean cookieSecure;

    private final JwtTokenProvider jwtTokenProvider;

    private final RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        if (response.isCommitted()) {
            return;
        }

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Long userId = userDetails.userId();

        log.info("로그인 성공! JWT 발급 시작. 유저 ID: {}", userId);
        String accessToken = jwtTokenProvider.createAccessToken(userId);

        // TODO : 정확히 비활성화 시점을 모르겠지만 원래는 세션의 context를 비활성화 해줘야함

        String redirectUri = request.getParameter("redirect_uri");
        if (redirectUri == null || redirectUri.isBlank()) {
            SavedRequest saved = requestCache.getRequest(request, response);
            redirectUri = (saved != null) ? saved.getRedirectUrl() : "/admin";
        } // 어떻게든 admin으로 보내볼려고


        Cookie cookie = new Cookie("accessToken", accessToken);
        cookie.setHttpOnly(true);
        cookie.setSecure(cookieSecure);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        if (!response.isCommitted()) {
            response.sendRedirect(redirectUri); // 한 번만
        }
    }
}