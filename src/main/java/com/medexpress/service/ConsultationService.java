package com.medexpress.service;

import com.medexpress.model.ConsultationAnswer;
import com.medexpress.model.ConsultationQuestion;
import com.medexpress.model.ConsultationResponse;

import java.util.List;

public interface ConsultationService {
    List<ConsultationQuestion> retrieveQuestion();
    ConsultationResponse consultation(ConsultationAnswer answers);
}
