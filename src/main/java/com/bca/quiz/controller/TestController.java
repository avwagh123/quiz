package com.bca.quiz.controller;

import com.bca.quiz.model.Question;
import com.bca.quiz.model.Test;
import com.bca.quiz.service.TestService;
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
@RequestMapping("test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping
    public List<Test> findAll(){
        return testService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Test> findById(@PathVariable Long id){
        return testService.findById(id);
    }

    @GetMapping("{testId}/questions")
    public List<Question> findQuestionsByTestId(@PathVariable Long testId){
        return testService.findQuestionsByTestId(testId);
    }

    @PostMapping
    public Test save(@RequestBody Test test){
        return testService.save(test);
    }

    @PutMapping
    public Test update(@RequestBody Test test){
        return testService.save(test);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        testService.deleteById(id);
    }

}
