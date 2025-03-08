package com.bca.quiz.responsedto;

import com.bca.quiz.model.Choice;
import com.bca.quiz.model.Question;
import java.sql.Timestamp;

public class ChoiceResponseDTO {
    private Long choiceId;
    private String choiceText;
    //private boolean isCorrect;
    private Timestamp createdAt;
    private Question question;

    public ChoiceResponseDTO(){}

    public ChoiceResponseDTO(Choice choice){
        this.choiceId = choice.getChoiceId();
        this.choiceText = choice.getChoiceText();
        //this.isCorrect = choice.isCorrect();
        this.createdAt = choice.getCreatedAt();
        this.question = choice.getQuestion();
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

    /*public boolean isCorrect() {
        return isCorrect;
    }*/

    /*public void setCorrect(boolean correct) {
        isCorrect = correct;
    }*/

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
