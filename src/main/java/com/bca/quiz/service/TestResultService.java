package com.bca.quiz.service;

import com.bca.quiz.dao.TestResultRepository;
import com.bca.quiz.model.TestResult;
import com.bca.quiz.requestdto.TestResultRequestDTO;
import com.bca.quiz.responsedto.TestResultResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestResultService {
    @Autowired
    TestResultRepository testResultRepository;

    public List<TestResultResponseDTO> findAll(){
        List<TestResult> testResultList = testResultRepository.findAll();
        return testResultList.stream()
                .map(TestResultResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<TestResultResponseDTO> findById(Long testResultId){
        Optional<TestResult> testResult = testResultRepository.findById(testResultId);
        return Optional.ofNullable(testResult.map(TestResultResponseDTO::new)
                .orElseThrow(()-> new RuntimeException("Test not found with result Id: "+ testResultId)));
    }

    public TestResultResponseDTO save(TestResultRequestDTO testResultRequestDTO){
        TestResult testResult = new TestResult(testResultRequestDTO);
        TestResult savedTestResult = testResultRepository.save(testResult);
        return new TestResultResponseDTO(savedTestResult);
    }

    public void deleteById(Long testResultId){
        testResultRepository.deleteById(testResultId);
    }
}
