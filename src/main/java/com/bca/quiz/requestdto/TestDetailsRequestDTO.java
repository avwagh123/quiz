package com.bca.quiz.requestdto;

import com.bca.quiz.model.Question;
import java.util.List;

public class TestDetailsRequestDTO {
    private String testName;
    private String description;
    private List<Question> questions;

    public TestDetailsRequestDTO(){}

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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
