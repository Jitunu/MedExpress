package com.medexpress.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class ConsultationAnswer {

    @NotNull(message = "Answers list must not be null")
    @Size(min = 1, message = "Answers list must contain at least one answer")
    @Valid // Ensures each Answer in the list is validated
    private List<Answer> answers;
}
