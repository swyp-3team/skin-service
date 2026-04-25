package com.swyp3.skin.domain.routine.repository;

import com.swyp3.skin.domain.routine.domain.entity.RoutineGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoutineGroupRepository extends JpaRepository<RoutineGroup, Long> {
    List<RoutineGroup> findTop4ByUser_IdOrderByCreatedAtDesc(Long userId);
    Page<RoutineGroup> findByUser_Id(Long userId, Pageable pageable);
    Optional<RoutineGroup> findByIdAndUser_Id(Long routineGroupId, Long userId);
}
