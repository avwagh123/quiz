package com.bca.quiz.controller;

import com.bca.quiz.model.Response;
import com.bca.quiz.service.ResponseService;
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
@RequestMapping("/api/v1/response")
public class ResponseController {

    @Autowired
    ResponseService responseService;

    @GetMapping
    public List<Response> findAll(){
        return responseService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Response> findById(@PathVariable Long id){
        return responseService.findById(id);
    }

    @PostMapping
    public Response save(@RequestBody Response response){
        return responseService.save(response);
    }

    @PutMapping
    public Response update(@RequestBody Response response){
        return responseService.save(response);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        responseService.deleteById(id);
    }
}
