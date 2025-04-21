package com.example.analytics.kafka;

import com.example.analytics.service.AnalyticsService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsKafkaConsumer {

    private final AnalyticsService analyticsService;

    public AnalyticsKafkaConsumer(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @KafkaListener(topics = "analytics-topic", groupId = "analytics-group")
    public void listen(String message) {
        analyticsService.processEvent(message);
    }
}
