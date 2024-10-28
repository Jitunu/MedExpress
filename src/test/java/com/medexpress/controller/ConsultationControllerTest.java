package com.medexpress.controller;

import com.medexpress.model.ConsultationResponse;
import com.medexpress.service.ConsultationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ConsultationController.class)
class ConsultationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultationService consultationService;

    @Test
    void getQuestions_ShouldReturnQuestions() throws Exception {
        mockMvc.perform(get("/api/v1/consultation/questions"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void submitAnswers_ShouldReturnEligibilityStatus() throws Exception {
        ConsultationResponse response = new ConsultationResponse(false, "We cannot prescribe the medication.");
        // Mocking the expected behavior
        Mockito.when(consultationService.consultation(Mockito.any()))
               .thenReturn(response);  // or `false` based on your needs

        // Request JSON payload
        String consultationAnswerJson = "{ \"answers\": [ { \"questionId\": \"1\", \"answer\": \"yes\" } ] }";

        mockMvc.perform(post("/api/v1/consultation/submit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(consultationAnswerJson))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.canPrescribe").value(false));
    }
}
