package com.medexpress.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsultationResponse {
    private boolean canPrescribe;
    private String message;
}
