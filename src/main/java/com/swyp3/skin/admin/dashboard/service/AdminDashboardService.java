package com.swyp3.skin.admin.dashboard.service;

import com.swyp3.skin.admin.dashboard.dto.DashBoardResponse;
import com.swyp3.skin.domain.product.repository.ProductRepository;
import com.swyp3.skin.domain.skinresult.repository.SkinResultRepository;
import com.swyp3.skin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class AdminDashboardService {

    private static final ZoneId KST = ZoneId.of("Asia/Seoul");

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final SkinResultRepository skinResultRepository;

    public DashBoardResponse getDashboard() {

        LocalDate today = LocalDate.now(KST);

        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.plusDays(1).atStartOfDay();

        long todaySignUpCount = userRepository.countByCreatedAtBetween(start, end);
        long totalUserCount = userRepository.count();

        long totalProductCount = productRepository.count();
        long activeProductCount = productRepository.countByActiveTrue();

        long totalDiagnoses = skinResultRepository.count();

        return DashBoardResponse.from(
                todaySignUpCount,
                totalUserCount,
                totalProductCount,
                activeProductCount,
                totalDiagnoses
        );
    }
}
