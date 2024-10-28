package com.medexpress.service;

import com.medexpress.model.ConsultationAnswer;
import com.medexpress.model.ConsultationQuestion;
import com.medexpress.model.ConsultationResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {
    private List<ConsultationQuestion> questions;
    @Override
    public List<ConsultationQuestion> retrieveQuestion() {
        this.questions = new ArrayList<>();
        questions.add(new ConsultationQuestion("1","Have you had an allergic reaction to pears?", List.of("Yes", "No")));
        questions.add(new ConsultationQuestion("2","Do you have any other allergies?", List.of("Yes", "No")));
        questions.add(new ConsultationQuestion("3","Are you currently taking any medications?", List.of("Yes", "No")));
        return questions;
    }

    @Override
    public ConsultationResponse consultation(ConsultationAnswer answers) {
        boolean canPrescribe = !answers.getAnswers().stream().anyMatch(i -> i.getAnswer().equalsIgnoreCase("Yes"));
        String message = canPrescribe ? "You are likely eligible for a prescription." : "We cannot prescribe the medication.";
        return new ConsultationResponse(canPrescribe, message);
    }
}
