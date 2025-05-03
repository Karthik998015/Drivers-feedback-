package com.driverfeedback.service;

import com.driverfeedback.model.Feedback;
import com.driverfeedback.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    
    private final FeedbackRepository feedbackRepository;
    
    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
    
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
    
    public List<Feedback> getFeedbacksByDriverName(String driverName) {
        return feedbackRepository.findByDriverName(driverName);
    }
} 