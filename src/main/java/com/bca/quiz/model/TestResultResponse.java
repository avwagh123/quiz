package com.bca.quiz.model;

import java.util.List;

public class TestResultResponse {
    private int score;
    private List<QuestionResult> questionResults;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<QuestionResult> getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(List<QuestionResult> questionResults) {
        this.questionResults = questionResults;
    }
}
