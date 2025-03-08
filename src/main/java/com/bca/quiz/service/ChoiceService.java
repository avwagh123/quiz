package com.bca.quiz.service;

import com.bca.quiz.dao.ChoiceRepository;
import com.bca.quiz.model.Choice;
import com.bca.quiz.model.User;
import com.bca.quiz.requestdto.ChoiceRequestDTO;
import com.bca.quiz.responsedto.ChoiceResponseDTO;
import com.bca.quiz.responsedto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChoiceService {
    @Autowired
    ChoiceRepository choiceRepository;

    public List<ChoiceResponseDTO> findAll(){
        List<Choice> choices = choiceRepository.findAll();
        return choices.stream().map(ChoiceResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<ChoiceResponseDTO> findById(Long choiceId){
        return Optional.ofNullable(choiceRepository.findById(choiceId)
                .map(ChoiceResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Choice not found with choice ID: " + choiceId)));
    }

    public ChoiceResponseDTO save(ChoiceRequestDTO choiceRequestDTO){
        Choice requestChoice = new Choice(choiceRequestDTO);
        Choice savedChoice = choiceRepository.save(requestChoice);
        return new ChoiceResponseDTO(savedChoice);
    }

    public void deleteById(Long choiceId){
        choiceRepository.deleteById(choiceId);
    }
}
