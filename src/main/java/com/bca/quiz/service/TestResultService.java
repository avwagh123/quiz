package com.bca.quiz.service;

import com.bca.quiz.dao.TestResultRepository;
import com.bca.quiz.model.TestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestResultService {
    @Autowired
    TestResultRepository testResultRepository;

    public List<TestResult> findAll(){
        return testResultRepository.findAll();
    }

    public Optional<TestResult> findById(Long testResultId){
        return testResultRepository.findById(testResultId);
    }

    public TestResult save(TestResult testResult){
        return testResultRepository.save(testResult);
    }

    public void deleteById(Long testResultId){
        testResultRepository.deleteById(testResultId);
    }
}
