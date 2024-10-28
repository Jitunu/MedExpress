package com.medexpress.service;


import com.medexpress.model.Answer;
import com.medexpress.model.ConsultationAnswer;
import com.medexpress.model.ConsultationQuestion;
import com.medexpress.model.ConsultationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class ConsultationServiceTest {

    private ConsultationService consultationService;

    @BeforeEach
    void setUp() {
        consultationService = new ConsultationServiceImpl();
    }

    @Test
    void testRetrieveAllQuestions() {
        List<ConsultationQuestion> question = consultationService.retrieveQuestion();
        Assertions.assertNotNull(question);
        Assertions.assertEquals(3, question.size());
    }

    @Test
    void evaluateConsultation_ShouldReturnFalseForValidAnswers() {
        // Given
        ConsultationAnswer consultationAnswer = new ConsultationAnswer();
        consultationAnswer.setAnswers(List.of(new Answer("q1", "yes"), new Answer("q2", "no")));

        // When
        ConsultationResponse result = consultationService.consultation(consultationAnswer);

        // Then
        Assertions.assertFalse(result.isCanPrescribe());
        Assertions.assertEquals( "We cannot prescribe the medication.",result.getMessage());
    }

    @Test
    void evaluateConsultation_ShouldReturnTrueForInvalidAnswers() {
        // Given
        ConsultationAnswer consultationAnswer = new ConsultationAnswer();
        consultationAnswer.setAnswers(List.of(new Answer("q1", "no")));

        // When
        ConsultationResponse result = consultationService.consultation(consultationAnswer);

        // Then
        Assertions.assertTrue(result.isCanPrescribe());
        Assertions.assertEquals( "You are eligible for a prescription.",result.getMessage());
    }
}
