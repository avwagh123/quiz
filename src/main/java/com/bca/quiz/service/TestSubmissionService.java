package com.bca.quiz.service;

import com.bca.quiz.dao.*;
import com.bca.quiz.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestSubmissionService {

    @Autowired
    private TestAttemptRepository testAttemptRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestDetailsRepository testRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ChoiceRepository choiceRepository;

    public TestResultResponse processTestSubmission(TestSubmissionRequest request) {
        // Fetch user and test
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TestDetails testDetails = testRepository.findById(request.getTestId())
                .orElseThrow(() -> new RuntimeException("Test not found"));

        // Create a new test attempt
        TestAttempt testAttempt = new TestAttempt();
        testAttempt.setUser(user);
        testAttempt.setTestDetails(testDetails);
        testAttempt.setAttemptDate(LocalDateTime.now());

        int totalQuestions = request.getResponses().size();
        int correctAnswers = 0;
        List<QuestionResult> questionResults = new ArrayList<>();

        for (QuestionResponse response : request.getResponses()) {
            Question question = questionRepository.findById(response.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            // Fetch correct choices
            List<Choice> correctChoices = question.getChoices().stream()
                    .filter(Choice::getCorrect)
                    .toList();

            List<Long> correctChoiceIds = correctChoices.stream()
                    .map(Choice::getChoiceId)
                    .toList();

            // Check if user's selected choices match correct choices
            boolean isCorrect = new HashSet<>(correctChoiceIds).equals(new HashSet<>(response.getSelectedChoiceIds()));

            if (isCorrect) {
                correctAnswers++; // Increment correct answer count
            }

            // Get selected choices
            List<Choice> selectedChoices = choiceRepository.findAllById(response.getSelectedChoiceIds());

            // Prepare QuestionResult object
            QuestionResult questionResult = new QuestionResult();
            questionResult.setQuestionId(question.getQuestionId());
            questionResult.setQuestionText(question.getQuestionText());
            questionResult.setQuestionType(question.getQuestionType().name());
            questionResult.setSelectedChoices(selectedChoices.stream()
                    .map(c -> new ChoiceDTO(c.getChoiceId(), c.getChoiceText()))
                    .toList());
            questionResult.setCorrectChoices(correctChoices.stream()
                    .map(c -> new ChoiceDTO(c.getChoiceId(), c.getChoiceText()))
                    .toList());

            questionResults.add(questionResult);
        }

        // Calculate final score
        int finalScore = (int) ((correctAnswers / (double) totalQuestions) * 100);
        testAttempt.setScore(finalScore);
        testAttemptRepository.save(testAttempt);

        // Prepare response
        TestResultResponse testResultResponse = new TestResultResponse();
        testResultResponse.setScore(finalScore);
        testResultResponse.setQuestionResults(questionResults);

        return testResultResponse;
    }
}

