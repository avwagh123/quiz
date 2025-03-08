package com.bca.quiz.model;

import com.bca.quiz.responsedto.ChoiceResponseDTO;

import java.util.List;

public class QuestionResult {
    private Long questionId;
    private String questionText;
    private String questionType;
    private List<ChoiceDTO> selectedChoices;
    private List<ChoiceDTO> correctChoices;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public List<ChoiceDTO> getSelectedChoices() {
        return selectedChoices;
    }

    public void setSelectedChoices(List<ChoiceDTO> selectedChoices) {
        this.selectedChoices = selectedChoices;
    }

    public List<ChoiceDTO> getCorrectChoices() {
        return correctChoices;
    }

    public void setCorrectChoices(List<ChoiceDTO> correctChoices) {
        this.correctChoices = correctChoices;
    }
}
