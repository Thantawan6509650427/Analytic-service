package com.example.analytics;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventListener {

    private final EventLogRepository repository;

    public EventListener(EventLogRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = {
        "UserRegistered", "ReservationCreated", 
        "PaymentProcessed", "ReviewSubmitted", 
        "RestaurantUpdated"
    }, groupId = "analytics-group")
    public void handleEvent(String message) {
        EventLog log = new EventLog();
        log.setPayload(message);
        log.setEventType("GenericEvent");
        repository.save(log);
    }
}
