package com.bca.quiz.service;

import com.bca.quiz.dao.TestAttemptRepository;
import com.bca.quiz.dao.TestDetailsRepository;
import com.bca.quiz.model.TestAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestAttemptService {
    @Autowired
    TestAttemptRepository testAttemptRepository;

    public List<TestAttempt> findAll() {
        return testAttemptRepository.findAll();
    }

    public void deleteById(Long id) {
        testAttemptRepository.deleteById(id);
    }
}
