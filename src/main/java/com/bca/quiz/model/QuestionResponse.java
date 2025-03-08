package com.bca.quiz.model;

import java.util.List;

public class QuestionResponse {
    private Long questionId;
    private List<Long> selectedChoiceIds;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public List<Long> getSelectedChoiceIds() {
        return selectedChoiceIds;
    }

    public void setSelectedChoiceIds(List<Long> selectedChoiceIds) {
        this.selectedChoiceIds = selectedChoiceIds;
    }
}
