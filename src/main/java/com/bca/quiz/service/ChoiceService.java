package com.bca.quiz.service;

import com.bca.quiz.dao.ChoiceRepository;
import com.bca.quiz.model.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChoiceService {
    @Autowired
    ChoiceRepository choiceRepository;

    public List<Choice> findAll(){
        return choiceRepository.findAll();
    }

    public Optional<Choice> findById(Long choiceId){
        return choiceRepository.findById(choiceId);
    }

    public Choice save(Choice choice){
        return choiceRepository.save(choice);
    }

    public void deleteById(Long choiceId){
        choiceRepository.deleteById(choiceId);
    }
}
