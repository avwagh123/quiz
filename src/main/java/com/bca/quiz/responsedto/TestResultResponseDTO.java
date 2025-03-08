package com.bca.quiz.responsedto;

import com.bca.quiz.model.TestDetails;
import com.bca.quiz.model.TestResult;
import com.bca.quiz.model.User;

import java.sql.Timestamp;

public class TestResultResponseDTO {
    private int resultId;
    private User user;
    private TestDetails test;
    private int score;
    private int totalQuestions;
    private Timestamp createdAt;

    public TestResultResponseDTO(){}

    public TestResultResponseDTO(TestResult testResult){
        this.resultId = testResult.getResultId();
        this.user = testResult.getUser();
        this.test = testResult.getTest();
        this.score = testResult.getScore();
        this.totalQuestions = testResult.getTotalQuestions();
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TestDetails getTest() {
        return test;
    }

    public void setTest(TestDetails test) {
        this.test = test;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
