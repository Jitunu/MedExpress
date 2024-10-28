package com.medexpress.controller;

import com.medexpress.model.ConsultationAnswer;
import com.medexpress.model.ConsultationQuestion;
import com.medexpress.model.ConsultationResponse;
import com.medexpress.service.ConsultationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/consultation")
public class ConsultationController {
    private static final Logger logger = LoggerFactory.getLogger(ConsultationController.class);
    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping("/questions")
    public ResponseEntity<List<ConsultationQuestion>> retrieveQuestion() {
        logger.info("Retrieving List of question");
        List<ConsultationQuestion> listOfQuestion = consultationService.retrieveQuestion();
        return ResponseEntity.ok(listOfQuestion);
    }

    @PostMapping("/submit")
    public ResponseEntity<ConsultationResponse> submitAnswers(@Valid @RequestBody ConsultationAnswer answers) {
        logger.info("Consultation Started");
        ConsultationResponse consultation = consultationService.consultation(answers);
        logger.info("Consultation Finished : "+consultation.getMessage());
        return ResponseEntity.ok(consultation);
    }
}
