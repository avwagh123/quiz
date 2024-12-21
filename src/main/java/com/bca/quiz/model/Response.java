package com.bca.quiz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "responses")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id")
    private int responseId;

    @ManyToOne
    @JoinColumn(name = "result_id", nullable = false)
    private TestResult testResult;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "chosen_choice_id", nullable = false)
    private Choice chosenChoice;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    // Getters and setters
}

