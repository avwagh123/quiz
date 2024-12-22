package com.bca.quiz.service;

import com.bca.quiz.dao.QuestionRepository;
import com.bca.quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public List<Question> findAll(){
        return questionRepository.findAll();
    }

    public Optional<Question> findById(Long choiceId){
        return questionRepository.findById(choiceId);
    }

    public Question save(Question question){
        return questionRepository.save(question);
    }

    public void deleteById(Long questionId){
        questionRepository.deleteById(questionId);
    }

    public List<Question> findQuestionsByTestId(Long testId){
        return questionRepository.findQuestionsByTestId(testId);
    }
}
