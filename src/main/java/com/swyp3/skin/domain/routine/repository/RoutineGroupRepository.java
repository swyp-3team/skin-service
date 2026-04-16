package com.swyp3.skin.domain.routine.repository;

import com.swyp3.skin.domain.routine.domain.entity.RoutineGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutineGroupRepository extends JpaRepository<RoutineGroup, Long> {
    List<RoutineGroup> findTop4ByUser_IdOrderByCreatedAtDesc(Long userId);
}
