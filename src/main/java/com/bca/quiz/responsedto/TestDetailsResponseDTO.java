package com.bca.quiz.responsedto;

import com.bca.quiz.model.Question;
import com.bca.quiz.model.TestDetails;

import java.sql.Timestamp;
import java.util.List;

public class TestDetailsResponseDTO {
    private int testId;
    private String testName;
    private String description;
    private Timestamp createdAt;
    private List<Question> questions;

    public TestDetailsResponseDTO(){}

    public TestDetailsResponseDTO(TestDetails test) {
        this.testId = test.getTestId();
        this.testName = test.getTestName();
        this.description = test.getDescription();
        this.createdAt = test.getCreatedAt();
        List<Question> questionsList = test.getQuestions();

        questionsList.forEach(
                question -> question.getChoices()
                        .forEach(choice -> choice.setCorrect(false)));
        this.questions = questionsList;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
