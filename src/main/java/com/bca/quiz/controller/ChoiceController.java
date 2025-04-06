package com.bca.quiz.controller;

import com.bca.quiz.requestdto.ChoiceRequestDTO;
import com.bca.quiz.responsedto.ChoiceResponseDTO;
import com.bca.quiz.service.ChoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/choice")
//@CrossOrigin(origins = "http://localhost:4200")
public class ChoiceController {

    @Autowired
    ChoiceService choiceService;

    @GetMapping
    public List<ChoiceResponseDTO> findAll(){
        return choiceService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ChoiceResponseDTO> findById(@PathVariable Long id){
        return choiceService.findById(id);
    }

    @PostMapping
    public ChoiceResponseDTO save(@RequestBody ChoiceRequestDTO choice){
        return choiceService.save(choice);
    }

    @PutMapping
    public ChoiceResponseDTO update(@RequestBody ChoiceRequestDTO choice){
        return choiceService.save(choice);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        choiceService.deleteById(id);
    }
}
