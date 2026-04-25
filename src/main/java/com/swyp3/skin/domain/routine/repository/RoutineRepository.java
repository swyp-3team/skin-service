package com.swyp3.skin.domain.routine.repository;

import com.swyp3.skin.domain.routine.domain.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RoutineRepository extends JpaRepository<Routine, Long> {
    List<Routine> findByRoutineGroup_Id(Long routineGroupId);
}
