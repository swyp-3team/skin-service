package com.swyp3.skin.domain.routine.service;

import com.swyp3.skin.domain.routine.domain.entity.Routine;
import com.swyp3.skin.domain.routine.repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutineService {

    private final RoutineRepository routineRepository;

    public List<Routine> getTop4ByUserId(Long userId) {
        return routineRepository.findTop4ByUser_IdOrderByCreatedAtDesc(userId);
    }
}
