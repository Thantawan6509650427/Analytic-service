package com.example.analytics.service;

import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {
    public void processEvent(String message) {
        System.out.println("Received event: " + message);
    }
}
