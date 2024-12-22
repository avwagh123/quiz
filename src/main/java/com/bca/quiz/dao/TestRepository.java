package com.bca.quiz.dao;

import com.bca.quiz.model.Question;
import com.bca.quiz.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {
    @Query("SELECT q FROM Question q WHERE q.test.id = :testId")
    List<Question> findQuestionsByTestId(Long testId);
}
