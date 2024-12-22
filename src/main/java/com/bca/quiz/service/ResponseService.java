package com.bca.quiz.service;

import com.bca.quiz.dao.ResponseRepository;
import com.bca.quiz.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {
    @Autowired
    ResponseRepository responseRepository;

    public List<Response> findAll(){
        return responseRepository.findAll();
    }

    public Optional<Response> findById(Long responseId){
        return responseRepository.findById(responseId);
    }

    public Response save(Response response){
        return responseRepository.save(response);
    }

    public void deleteById(Long responseId){
        responseRepository.deleteById(responseId);
    }
}
