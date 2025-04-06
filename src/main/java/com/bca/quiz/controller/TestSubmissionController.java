package com.bca.quiz.controller;

import com.bca.quiz.model.TestResultResponse;
import com.bca.quiz.model.TestSubmissionRequest;
import com.bca.quiz.service.TestSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test-submissions")
//@CrossOrigin(origins = "http://localhost:4200")
public class TestSubmissionController {

    @Autowired
    private TestSubmissionService testSubmissionService;

    @PostMapping
    public ResponseEntity<TestResultResponse> submitTest(@RequestBody TestSubmissionRequest submissionRequest) {
        TestResultResponse response = testSubmissionService.processTestSubmission(submissionRequest);
        return ResponseEntity.ok(response);
    }
}