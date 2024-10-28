package com.medexpress.model;


import com.medexpress.validation.ValidAnswer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    private String questionId;

    @NotNull(message = "Answer must not be null")
    @NotBlank(message = "Answer must not be blank")
    @NotEmpty(message = "Answer must not be empty")
    private String answer;

    // Constructors, getters, and setters
//    public Answer(String questionId, String answer) {
//        this.questionId = questionId;
//        this.answer = answer;
//    }
//
//    public String getQuestionId() {
//        return questionId;
//    }
//
//    public void setQuestionId(String questionId) {
//        this.questionId = questionId;
//    }
//
//    public String getAnswer() {
//        return answer;
//    }
//
//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }
}