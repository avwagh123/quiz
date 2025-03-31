package com.bca.quiz.controller;

import com.bca.quiz.requestdto.TestDetailsRequestDTO;
import com.bca.quiz.responsedto.QuestionResponseDTO;
import com.bca.quiz.responsedto.TestDetailsResponseDTO;
import com.bca.quiz.service.TestDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/test-details")
@CrossOrigin(origins = "http://localhost:4200")
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
