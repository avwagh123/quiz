package com.bca.quiz.responsedto;

import com.bca.quiz.model.Choice;
import com.bca.quiz.model.Question;
import com.bca.quiz.model.QuestionType;
import com.bca.quiz.model.TestDetails;
import java.util.List;

public class QuestionResponseDTO {
    private long questionId;
    private String questionText;
    private QuestionType questionType;
    private TestDetails test;
    List<Choice> choices;

    public QuestionResponseDTO(Question question){
        this.questionId = question.getQuestionId();
        this.questionText = question.getQuestionText();
        this.questionType = question.getQuestionType();
        this.test = question.getTest();
        this.choices = question.getChoices();
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public TestDetails getTest() {
        return test;
    }

    public void setTest(TestDetails test) {
        this.test = test;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
}
