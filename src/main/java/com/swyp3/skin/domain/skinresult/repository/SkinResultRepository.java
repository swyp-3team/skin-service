package com.swyp3.skin.domain.skinresult.repository;

import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkinResultRepository extends JpaRepository<SkinResult,Long> {

    Optional<SkinResult> findTopByUser_IdOrderByCreatedAtDesc(Long userId);

    List<SkinResult> findTop4ByUser_IdOrderByCreatedAtDesc(Long userId);

    Optional<SkinResult> findByIdAndUser_id(Long id, Long userId);
}
