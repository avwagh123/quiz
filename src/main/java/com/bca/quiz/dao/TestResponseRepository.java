package com.bca.quiz.dao;

import com.bca.quiz.model.TestResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResponseRepository extends JpaRepository<TestResponse, Long> { }
