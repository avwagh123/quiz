package com.bca.quiz.controller;

import com.bca.quiz.model.Question;
import com.bca.quiz.service.QuestionService;
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
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping
    public List<Question> findAll(){
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Question> findById(@PathVariable Long id){
        return questionService.findById(id);
    }

    @PostMapping
    public Question save(@RequestBody Question question){
        return questionService.save(question);
    }

    @PutMapping
    public Question update(@RequestBody Question question){
        return questionService.save(question);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        questionService.deleteById(id);
    }
}
