package com.swyp3.skin.domain.skinresult.service;

import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
import com.swyp3.skin.domain.skinresult.domain.exception.SkinResultErrorCode;
import com.swyp3.skin.domain.skinresult.domain.exception.SkinResultException;
import com.swyp3.skin.domain.skinresult.repository.SkinResultRepository;
import com.swyp3.skin.domain.skintest.dto.SkinPreviewCacheValue;
import com.swyp3.skin.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SkinResultService {

    private final SkinResultRepository skinResultRepository;

    @Transactional
    public SkinResult save(User user, SkinPreviewCacheValue cached) {
        SkinResult skinResult = SkinResult.create(
                user, cached.skinInput().getSkinType(), cached.summary(), LocalDateTime.now()
        );
        return skinResultRepository.save(skinResult);
    }

    public SkinResult getLatestByUserId(Long userId) {
        return skinResultRepository.findTopByUserIdOrderByCreatedAtDesc(userId)
                .orElseThrow(() -> new SkinResultException(SkinResultErrorCode.SKIN_RESULT_NOT_YET));
    }
}
