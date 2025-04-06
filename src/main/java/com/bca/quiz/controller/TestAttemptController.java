package com.bca.quiz.controller;

import com.bca.quiz.model.TestAttempt;
import com.bca.quiz.service.TestAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test-attempt")
//@CrossOrigin(origins = "http://localhost:4200")
public class TestAttemptController {

    @Autowired
    private TestAttemptService testAttemptService;

    @GetMapping
    public List<TestAttempt> getAll(){
        return testAttemptService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        testAttemptService.deleteById(id);
    }
}
