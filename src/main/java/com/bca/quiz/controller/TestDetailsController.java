package com.bca.quiz.controller;

import com.bca.quiz.requestdto.TestDetailsRequestDTO;
import com.bca.quiz.responsedto.QuestionResponseDTO;
import com.bca.quiz.responsedto.TestDetailsResponseDTO;
import com.bca.quiz.service.TestDetailsService;
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
@RequestMapping("/api/v1/testdetails")
public class TestDetailsController {

    @Autowired
    TestDetailsService testService;

    @GetMapping
    public List<TestDetailsResponseDTO> findAll(){
        return testService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TestDetailsResponseDTO> findById(@PathVariable Long id){
        return testService.findById(id);
    }

    @GetMapping("{testId}/questions")
    public List<QuestionResponseDTO> findQuestionsByTestId(@PathVariable Long testId){
        return testService.findQuestionsByTestId(testId);
    }

    @PostMapping
    public TestDetailsResponseDTO save(@RequestBody TestDetailsRequestDTO test){
        return testService.save(test);
    }

    @PutMapping
    public TestDetailsResponseDTO update(@RequestBody TestDetailsRequestDTO test){
        return testService.save(test);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        testService.deleteById(id);
    }

}
