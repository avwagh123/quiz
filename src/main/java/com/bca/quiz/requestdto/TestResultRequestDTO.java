package com.bca.quiz.requestdto;

import com.bca.quiz.model.TestDetails;
import com.bca.quiz.model.User;

public class TestResultRequestDTO {
    private User user;
    private TestDetails test;
    private int score;
    private int totalQuestions;

    public TestResultRequestDTO(){

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
}
