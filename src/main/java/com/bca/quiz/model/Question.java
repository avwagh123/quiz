package com.bca.quiz.model;

import com.bca.quiz.requestdto.QuestionRequestDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @Enumerated(EnumType.STRING)
    @Column(name = "question_type", nullable = false)
    private QuestionType questionType;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    @JsonIgnore
    private TestDetails test;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    List<Choice> choices;

    public Question(QuestionRequestDTO questionRequestDTO) {
            this.questionText = questionRequestDTO.getQuestionText();
        this.questionType = questionRequestDTO.getQuestionType();
        this.test = questionRequestDTO.getTest();
        questionRequestDTO.getChoices().forEach(choice -> choice.setCreatedAt(new Timestamp(System.currentTimeMillis())));
        questionRequestDTO.getChoices().forEach(choice -> choice.setQuestion(this));
        this.choices = questionRequestDTO.getChoices();
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public void addChoice(Choice choice){
        if(choices == null){
            choices = new ArrayList<>();
        }
        choices.add(choice);
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public TestDetails getTest() {
        return test;
    }

    public void setTest(TestDetails test) {
        this.test = test;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Question(){

    }

    public Question(TestDetails test, String questionText, QuestionType questionType) {
        this.test = test;
        this.questionText = questionText;
        this.questionType = questionType;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}
