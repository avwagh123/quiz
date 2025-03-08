package com.bca.quiz.service;

import com.bca.quiz.dao.QuestionRepository;
import com.bca.quiz.model.Choice;
import com.bca.quiz.model.Question;
import com.bca.quiz.requestdto.QuestionRequestDTO;
import com.bca.quiz.responsedto.ChoiceResponseDTO;
import com.bca.quiz.responsedto.QuestionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public List<QuestionResponseDTO> findAll(){
        List<Question> questionList = questionRepository.findAll();
        return questionList.stream()
                .map(QuestionResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<QuestionResponseDTO> findById(Long choiceId){
        return Optional.ofNullable(questionRepository.findById(choiceId)
                .map(QuestionResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Question not found with choice Id: " + choiceId)));
    }

    public QuestionResponseDTO save(QuestionRequestDTO questionRequestDTO){
        Question question = new Question(questionRequestDTO);
        Question savedQuestion = questionRepository.save(question);
        return new QuestionResponseDTO(savedQuestion);
    }

    public void deleteById(Long questionId){
        questionRepository.deleteById(questionId);
    }

    public List<QuestionResponseDTO> findQuestionsByTestId(Long testId){
        List<Question> questionList = questionRepository.findQuestionsByTestId(testId);
        return questionList.stream()
                .map(QuestionResponseDTO::new)
                .collect(Collectors.toList());
    }

    public List<ChoiceResponseDTO> getChoicesByQuestionId(Long questionId) {
        List<Choice> choiceList = questionRepository.getChoicesByQuestionId(questionId);
        return choiceList.stream()
                .map(ChoiceResponseDTO::new)
                .collect(Collectors.toList());
    }
}
