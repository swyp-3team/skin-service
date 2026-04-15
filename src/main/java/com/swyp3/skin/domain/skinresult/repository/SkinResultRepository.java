package com.swyp3.skin.domain.skinresult.repository;

import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface SkinResultRepository extends JpaRepository<SkinResult,Long> {

    Optional<SkinResult> findTopByUserIdOrderByCreatedAtDesc(Long userId);
}
