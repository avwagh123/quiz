package com.bca.quiz.requestdto;

import com.bca.quiz.model.Choice;
import com.bca.quiz.model.QuestionType;
import com.bca.quiz.model.TestDetails;

import java.util.List;

public class QuestionRequestDTO {
    private String questionText;
    private QuestionType questionType;
    private TestDetails test;
    List<Choice> choices;

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
}
