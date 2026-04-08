package com.swyp3.skin.api.v1.routine.controller;

import com.swyp3.skin.api.v1.routine.dto.response.RoutineDetailResponse;
import com.swyp3.skin.api.v1.routine.dto.response.RoutineListResponse;
import com.swyp3.skin.api.v1.routine.dto.response.RoutineRecommendationResponse;
import com.swyp3.skin.api.v1.routine.dto.response.SaveRoutineResponse;
import com.swyp3.skin.global.response.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Routine", description = "루틴 추천 및 저장 관리")
@RestController
@RequestMapping("/api/v1/routines")
public class RoutineController {

    @Operation(
            summary = "맞춤형 루틴 추천",
            description = "최신 피부 진단 결과를 기반으로 사용자의 AM/PM 루틴 미리보기 정보를 반환"
    )
    @GetMapping("/recommendation")
    public ApiResponse<RoutineRecommendationResponse> getRecommendation() {
        // TODO:
        // 최신 피부 진단 결과 조회
        // 추천 엔진으로 AM/PM 루틴 계산
        // 추천 결과를 세션 또는 임시 저장소에 보관
        // 응답 DTO로 반환
        return null;
    }

    @Operation(
            summary = "루틴 저장",
            description = "직전에 추천된 AM/PM 루틴 결과를 그대로 사용자의 루틴으로 저장"
    )
    @PostMapping
    public ApiResponse<SaveRoutineResponse> saveRoutine(){
        // TODO :
        // 직전 생성된 루틴 추천 결과 조회
        // 추천 결과 없으면 예외처리(ex.생성된 루틴이 없습니다)
        // 루틴 그룹 생성
        // 생성 루틴 그룹 기준으로 각 타입별 루틴 저장
        // 각 루틴 하위 루틴 프로덕트 저장
        // 저장 완료 응답 DTO반환
        return null;
    }

    @Operation(
            summary = "루틴 목록 조회",
            description = "사용자가 저장한 루틴 이력을 페이지 단위로 조회"
    )
    @GetMapping
    public ApiResponse<RoutineListResponse> getRoutines(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        // TODO :
        // 사용자 루틴 목록 조회
        // 페이지 응답 DTO로 반환
        return null;
    }

    @Operation(
            summary = "루틴 상세 조회",
            description = "선택한 루틴의 AM/PM 구성, 사용 순서, 추천 이유, 주의사항을 함께 조회"
    )
    @GetMapping("/{routineGroupId}")
    public ApiResponse<RoutineDetailResponse> getRoutine(@PathVariable Long routineGroupId) {
        // TODO :
        // 루틴그룹 아이디 기준 루틴 그룹 조회
        // 그룹에 속한 각 루틴 조회
        // 각 루틴에 포함된 루틴 프로덕트 조회
        // 응답 DTO로 반환
        return null;
    }
    @Operation(
            summary = "루틴 삭제",
            description = "선택한 루틴 기준으로 동일 그룹의 AM/PM 루틴과 하위 데이터를 함께 삭제"
    )
    @DeleteMapping("/{routineGroupId}")
    public ApiResponse<Void> deleteRoutine(
            @Parameter(description = "삭제할 루틴 대표 ID", example = "1")
            @PathVariable Long routineGroupId
    ) {
        // TODO:
        // 그룹아이디 기준 삭제 대상 조회
        // 그룹에 속한 루틴및 루틴 프로덕트 삭제
        // 루틴 그룹 삭제
        return ApiResponse.ok();
    }
}
