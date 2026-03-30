package com.swyp3.skin.domain.routine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Routine API", description = "루틴 REST 컨트롤러")
@RestController
@RequestMapping("/api/routine")
public class RoutineRestController {

    @Operation(summary = "루틴 순서 추천", description = "ROUTINE_TYPE + 제품 리스트 → 추천 순서 JSON 반환")
    @PostMapping("/order")
    public ResponseEntity<?> recommendOrder(@RequestParam String routineType,
                                            @RequestParam List<Long> productIds) {
        // TODO 기본 스킨케어 순서 + 시간대별 추가 순서 로직 확정후 작성
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "성분 충돌 검사", description = "제품 성분 리스트 → 중복 경고 JSON 반환 · 실시간 체크")
    @PostMapping("/conflict")
    public ResponseEntity<?> checkConflict(@RequestParam List<Long> productIds) {
        // TODO 동일 성분 카운트 + 임계값 초과 판단 로직등 성분충돌이 무슨기준으로 일어날지 결정후 작성
        return ResponseEntity.ok().build();
    }
}