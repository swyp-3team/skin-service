package com.swyp3.skin.api.v1.skintest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swyp3.skin.api.v1.skintest.dto.request.SkinTestPreviewRequest;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestPreviewResponse;
import com.swyp3.skin.api.v1.skintest.mapper.SkinInputMapper;
import com.swyp3.skin.api.v1.skintest.mapper.SkinTestPreviewResponseMapper;
import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.domain.skinresult.domain.enums.Concern;
import com.swyp3.skin.domain.skinresult.domain.enums.SkinType;
import com.swyp3.skin.domain.skinttest.service.SkinTestApplicationService;
import com.swyp3.skin.global.exception.GlobalExceptionHandler;
import com.swyp3.skin.recommendation.model.RecommendationResult;
import com.swyp3.skin.recommendation.model.SkinInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SkinTestController.class)
@Import(GlobalExceptionHandler.class)
@AutoConfigureMockMvc(addFilters = false)
class SkinTestControllerTest {

    @Autowired MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    SkinTestPreviewRequest skinTestPreviewRequest;

    @MockitoBean
    SkinInputMapper skinInputMapper;

    @MockitoBean
    SkinTestApplicationService skinTestApplicationService;

    @MockitoBean
    SkinTestPreviewResponseMapper skinTestPreviewResponseMapper;

    @Test
    void 정상요청이면_정상응답_반환() throws Exception {

        // given
        int step = 1;

        // when
        ResultActions result = mockMvc.perform(
                get("/api/v1/surveys").param("step", String.valueOf(step))
        );

        // then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.step").value(step))
                .andExpect(jsonPath("$.data.question").exists())
                .andExpect(jsonPath("$.error").doesNotExist());
    }

    @Test
    void 질문에없는_스탭_미만경우() throws Exception {

        // given
        int step = 0;
        // when
        ResultActions result = mockMvc.perform(
                get("/api/v1/surveys").param("step", String.valueOf(step))
        );
        // then
        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.error.code").value("COMMON_400"));
    }

    @Test
    void 질문에없는_스탭_초과경우() throws Exception {

        // given
        int step = 999;
        // when
        ResultActions result = mockMvc.perform(
                get("/api/v1/surveys").param("step", String.valueOf(step))
        );
        // then
        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.error.code").value("SKIN_TEST_400_001"));
    }

    @Test
    void 유효한_preview요청_200_top3반환() throws Exception {
        // given
        SkinTestPreviewRequest request = new SkinTestPreviewRequest(
                List.of(
                        new SkinTestPreviewRequest.AnswerDto(1, 5),
                        new SkinTestPreviewRequest.AnswerDto(2, 4),
                        new SkinTestPreviewRequest.AnswerDto(3, 3),
                        new SkinTestPreviewRequest.AnswerDto(4, 3),
                        new SkinTestPreviewRequest.AnswerDto(5, 3),
                        new SkinTestPreviewRequest.AnswerDto(6, 5),
                        new SkinTestPreviewRequest.AnswerDto(7, 4),
                        new SkinTestPreviewRequest.AnswerDto(8, 3),
                        new SkinTestPreviewRequest.AnswerDto(9, 3),
                        new SkinTestPreviewRequest.AnswerDto(10, 1),
                        new SkinTestPreviewRequest.AnswerDto(11, 5),
                        new SkinTestPreviewRequest.AnswerDto(12, 4),
                        new SkinTestPreviewRequest.AnswerDto(13, 3)
                ),
                SkinType.OILY,
                List.of(Concern.ACNE, Concern.SEBUM)
        );

        // when
        // mock 반환용 객체는 직접 생성
        SkinInput skinInput = new SkinInput(Map.of(), List.of(Concern.ACNE), SkinType.OILY);
        RecommendationResult result = new RecommendationResult(
                Map.of(),
                List.of(IngredientGroup.SOOTHING, IngredientGroup.ACNE, IngredientGroup.SEBUM_CONTROL)
        );
        SkinTestPreviewResponse response = new SkinTestPreviewResponse(
                SkinType.OILY,
                "요약",
                List.of(
                        new SkinTestPreviewResponse.TopIngredientDto(
                                IngredientGroup.SOOTHING, 1, List.of("판테놀"), "진정 필요"
                        )
                )
        );
        // then
        when(skinInputMapper.toSkinInput(any(SkinTestPreviewRequest.class)))
                .thenReturn(skinInput);

        when(skinTestApplicationService.calculate(any(SkinInput.class)))
                .thenReturn(result);

        when(skinTestPreviewResponseMapper.toResponse(any(SkinType.class), any(RecommendationResult.class)))
                .thenReturn(response);

        mockMvc.perform(post("/api/v1/result/preview")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.skinType").value("OILY"))
                .andExpect(jsonPath("$.data.top3[0].group").value("SOOTHING"));
    }

}

