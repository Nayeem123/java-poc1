package com.example.Module2.service;

import com.example.Module2.dto.UserPreference;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaProducer {
    private final KafkaTemplate<String, UserPreference> kafkaTemplate;

    public MyKafkaProducer(KafkaTemplate<String, UserPreference> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, UserPreference message) {

        kafkaTemplate.send(topic, message);
    }
}
