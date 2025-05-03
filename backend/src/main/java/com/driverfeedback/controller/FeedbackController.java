package com.driverfeedback.controller;

import com.driverfeedback.model.Feedback;
import com.driverfeedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {
    
    private final FeedbackService feedbackService;
    
    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        return ResponseEntity.ok(feedbackService.saveFeedback(feedback));
    }
    
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }
    
    @GetMapping("/driver/{driverName}")
    public ResponseEntity<List<Feedback>> getFeedbacksByDriver(@PathVariable String driverName) {
        return ResponseEntity.ok(feedbackService.getFeedbacksByDriverName(driverName));
    }
} 