package com.bca.quiz.controller;

import com.bca.quiz.requestdto.QuestionRequestDTO;
import com.bca.quiz.responsedto.ChoiceResponseDTO;
import com.bca.quiz.responsedto.QuestionResponseDTO;
import com.bca.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping
    public List<QuestionResponseDTO> findAll(){
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<QuestionResponseDTO> findById(@PathVariable Long id){
        return questionService.findById(id);
    }

    @GetMapping("test/{testId}")
    public List<QuestionResponseDTO> findQuestionsByTestId(@PathVariable Long testId){
        return questionService.findQuestionsByTestId(testId);
    }

    @PostMapping
    public QuestionResponseDTO save(@RequestBody QuestionRequestDTO question){
        return questionService.save(question);
    }

    @PutMapping
    public QuestionResponseDTO update(@RequestBody QuestionRequestDTO question){
        return questionService.save(question);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        questionService.deleteById(id);
    }

    @GetMapping("/{questionId}/choices")
    public List<ChoiceResponseDTO> getChoicesByQuestionId(@PathVariable Long questionId){
        return questionService.getChoicesByQuestionId(questionId);
    }
}
