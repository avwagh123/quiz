package com.bca.quiz.model;

public class ChoiceDTO {
    private Long choiceId;
    private String choiceText;

    public ChoiceDTO() {
    }

    public ChoiceDTO(Long choiceId, String choiceText) {
        this.choiceId = choiceId;
        this.choiceText = choiceText;
    }

    public Long getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(Long choiceId) {
        this.choiceId = choiceId;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }
}
