package com.swyp3.skin.admin.dashboard.dto;

public record DashBoardResponse(

        long todaySignUpCount,
        long totalUserCount,
        long totalProductCount,
        long activeProductCount,
        long totalDiagnoses
) {

    public static DashBoardResponse from(
            long todaySignUpCount,
            long totalUserCount,
            long totalProductCount,
            long activeProductCount,
            long totalDiagnoses) {
        return new DashBoardResponse(
                todaySignUpCount,
                totalUserCount,
                totalProductCount,
                activeProductCount,
                totalDiagnoses
        );
    }
}
