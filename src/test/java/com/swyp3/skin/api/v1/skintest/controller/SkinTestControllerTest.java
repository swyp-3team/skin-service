package com.swyp3.skin.api.v1.skintest.controller;

import com.swyp3.skin.global.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SkinTestController.class)
@Import(GlobalExceptionHandler.class)
@AutoConfigureMockMvc(addFilters = false)
class SkinTestControllerTest {

    @Autowired MockMvc mockMvc;

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
}