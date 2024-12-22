package com.bca.quiz.controller;

import com.bca.quiz.model.Choice;
import com.bca.quiz.service.ChoiceService;

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
@RequestMapping("choice")
public class ChoiceController {

    @Autowired
    ChoiceService choiceService;

    @GetMapping
    public List<Choice> findAll(){
        return choiceService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Choice> findById(@PathVariable Long id){
        return choiceService.findById(id);
    }

    @PostMapping
    public Choice save(@RequestBody Choice choice){
        return choiceService.save(choice);
    }

    @PutMapping
    public Choice update(@RequestBody Choice choice){
        return choiceService.save(choice);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        choiceService.deleteById(id);
    }
}