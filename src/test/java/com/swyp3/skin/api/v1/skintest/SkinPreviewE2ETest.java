//package com.swyp3.skin.api.v1.skintest;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.swyp3.skin.api.v1.skintest.dto.request.SkinTestPreviewRequest;
//import com.swyp3.skin.domain.skinresult.domain.enums.Concern;
//import com.swyp3.skin.domain.skinresult.domain.enums.SkinType;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc(addFilters = false)
//public class SkinPreviewE2ETest {
//
//    @Autowired MockMvc mockMvc;
//    @Autowired ObjectMapper objectMapper;
//
//
//    @Test
//    void preview_응답확인() throws Exception{
//        SkinTestPreviewRequest request = new SkinTestPreviewRequest(
//                List.of(
//                        new SkinTestPreviewRequest.AnswerDto(1, 5),
//                        new SkinTestPreviewRequest.AnswerDto(2, 4),
//                        new SkinTestPreviewRequest.AnswerDto(3, 3),
//                        new SkinTestPreviewRequest.AnswerDto(4, 3),
//                        new SkinTestPreviewRequest.AnswerDto(5, 3),
//                        new SkinTestPreviewRequest.AnswerDto(6, 5),
//                        new SkinTestPreviewRequest.AnswerDto(7, 4),
//                        new SkinTestPreviewRequest.AnswerDto(8, 3),
//                        new SkinTestPreviewRequest.AnswerDto(9, 3),
//                        new SkinTestPreviewRequest.AnswerDto(10, 1),
//                        new SkinTestPreviewRequest.AnswerDto(11, 5),
//                        new SkinTestPreviewRequest.AnswerDto(12, 4),
//                        new SkinTestPreviewRequest.AnswerDto(13, 3)
//                ),
//                SkinType.OILY,
//                List.of(Concern.ACNE, Concern.SEBUM)
//        );
//
//        mockMvc.perform(post("/api/v1/result/preview")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.success").value(true))
//                .andExpect(jsonPath("$.data.skinType").value("OILY"))
//                .andExpect(jsonPath("$.data.summary").isNotEmpty())
//                .andExpect(jsonPath("$.data.top3").isArray())
//                .andExpect(jsonPath("$.data.top3[0].group").isNotEmpty())
//                .andExpect(jsonPath("$.data.top3[0].priority").value(1))
//                .andExpect(jsonPath("$.data.top3[0].ingredients").isArray())
//                .andExpect(jsonPath("$.data.top3[0].reason").isNotEmpty());
//    }
//
//}
