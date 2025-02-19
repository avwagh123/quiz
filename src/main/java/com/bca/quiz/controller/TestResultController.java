package com.bca.quiz.controller;

import com.bca.quiz.model.TestResult;
import com.bca.quiz.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/testresult")
public class TestResultController {

    @Autowired
    TestResultService testResultService;

    @GetMapping
    public List<TestResult> findAll(){
        return testResultService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TestResult> findById(@PathVariable Long id){
        return testResultService.findById(id);
    }

    @PostMapping
    public TestResult save(@RequestBody TestResult testResult){
        return testResultService.save(testResult);
    }

    @PutMapping
    public TestResult update(@RequestBody TestResult testResult){
        return testResultService.save(testResult);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        testResultService.deleteById(id);
    }
}
