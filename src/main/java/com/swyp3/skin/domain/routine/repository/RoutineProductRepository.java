package com.swyp3.skin.domain.routine.repository;

import com.swyp3.skin.domain.routine.domain.entity.RoutineProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutineProductRepository extends JpaRepository<RoutineProduct, Long> {
    List<RoutineProduct> findByRoutine_Id(Long routineId);
    void deleteByRoutine_Id(Long routineId);
}
