package com.swyp3.skin.domain.skinresult.service;

import com.swyp3.skin.domain.skinresult.repository.SkinResultGroupScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkinResultGroupScoreService {

    private final SkinResultGroupScoreRepository skinResultGroupScoreRepository;
}
