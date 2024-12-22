package com.bca.quiz.dao;

import com.bca.quiz.model.Choice;
import com.bca.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q WHERE q.test.id = :testId")
    List<Question> findQuestionsByTestId(@Param("testId") Long testId);

    //@Query("SELECT c FROM Choice c WHERE c.question.id = :questionId")
    @Query("SELECT c FROM Choice c JOIN c.question q WHERE q.id = :questionId")
    List<Choice> getChoicesByQuestionId(@Param("questionId") Long questionId);
}
