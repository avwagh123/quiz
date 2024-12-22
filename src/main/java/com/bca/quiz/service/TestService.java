package com.bca.quiz.service;

import com.bca.quiz.dao.TestRepository;
import com.bca.quiz.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    public List<Test> findAll(){
        return testRepository.findAll();
    }

    public Optional<Test> findById(Long testId){
        return testRepository.findById(testId);
    }

    public Test save(Test test){
        return testRepository.save(test);
    }

    public void deleteById(Long testId){
        testRepository.deleteById(testId);
    }
}
