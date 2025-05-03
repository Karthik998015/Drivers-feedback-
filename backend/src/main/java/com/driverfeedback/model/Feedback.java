package com.driverfeedback.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String driverName;
    
    @Column(nullable = false)
    private String passengerName;
    
    @Column(nullable = false)
    private Integer rating;
    
    @Column(length = 1000)
    private String comment;
    
    @Column(nullable = false)
    private LocalDateTime feedbackDate;
    
    @PrePersist
    protected void onCreate() {
        feedbackDate = LocalDateTime.now();
    }
} 