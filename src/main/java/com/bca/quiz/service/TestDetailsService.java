package com.bca.quiz.service;

import com.bca.quiz.dao.TestDetailsRepository;
import com.bca.quiz.model.Question;
import com.bca.quiz.model.TestDetails;
import com.bca.quiz.requestdto.TestDetailsRequestDTO;
import com.bca.quiz.responsedto.QuestionResponseDTO;
import com.bca.quiz.responsedto.TestDetailsResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestDetailsService {
    @Autowired
    TestDetailsRepository testRepository;

    public List<TestDetailsResponseDTO> findAll(){
        List<TestDetails> testList = testRepository.findAll();
        return testList.stream().map(TestDetailsResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<TestDetailsResponseDTO> findById(Long testId){
        Optional<TestDetails> test = testRepository.findById(testId);
        return Optional.ofNullable(test
                .map(TestDetailsResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Test not found with test Id: " + testId)));
    }

    public TestDetailsResponseDTO save(TestDetailsRequestDTO testRequestDTO){
        TestDetails test = new TestDetails(testRequestDTO);
        TestDetails savedTest = testRepository.save(test);
        return new TestDetailsResponseDTO(savedTest);
    }

    public void deleteById(Long testId){
        testRepository.deleteById(testId);
    }

    public List<QuestionResponseDTO> findQuestionsByTestId(Long testId) {
        List<Question> questionList = testRepository.findQuestionsByTestId(testId);
        questionList.forEach(
                question -> question.getChoices()
                        .forEach(choice -> choice.setCorrect(false))
        );
        return questionList.stream()
                .map(QuestionResponseDTO::new)
                .collect(Collectors.toList());
    }
}
