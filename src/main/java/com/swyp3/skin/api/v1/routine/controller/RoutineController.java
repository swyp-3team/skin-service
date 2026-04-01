package com.swyp3.skin.api.routine;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Routine", description = "루틴 관리")
@RestController
@RequestMapping("/api/v1/routines")
@RequiredArgsConstructor
public class RoutineController {

    @Operation(summary = "루틴 추천 제품 조회")
    @GetMapping("/recommend-products")
    public Object getRecommendProducts(@RequestParam String routineType) {
        // TODO: 피부타입 기반 추천 제품 조회
        return null;
    }

    @Operation(summary = "루틴 사전 분석 (비저장)")
    @PostMapping("/analyze")
    public Object analyze(@RequestBody Object request) {
        // TODO: 순서 추천 + 성분 충돌 검사
        return null;
    }

    @Operation(summary = "루틴 저장 (완료 시)")
    @PostMapping
    public Object saveRoutine(@RequestBody Object request) {
        // TODO: Routine + RoutineProduct 생성 후 DB 저장
        return null;
    }

    @Operation(summary = "루틴 목록 조회")
    @GetMapping
    public Object getRoutines(@RequestParam(required = false) String routineType) {
        // TODO: 사용자 루틴 목록 조회
        return null;
    }

    @Operation(summary = "루틴 상세 조회")
    @GetMapping("/{routineId}")
    public Object getRoutine(@PathVariable Long routineId) {
        // TODO: 상세 조회 (제품 + 순서)
        return null;
    }

    @Operation(summary = "루틴 수정")
    @PutMapping("/{routineId}")
    public Object updateRoutine(@PathVariable Long routineId,
                                @RequestBody Object request) {
        // TODO: 기존 루틴 수정
        return null;
    }

    @Operation(summary = "루틴 삭제")
    @DeleteMapping("/{routineId}")
    public void deleteRoutine(@PathVariable Long routineId) {
        // TODO: 루틴 삭제
    }
}