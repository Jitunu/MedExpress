package com.medexpress.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ConsultationQuestion {
    private String questionId;
    private String question;
    private List<String> options;

}
