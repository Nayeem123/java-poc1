package com.example.Module2.controller;

import com.example.Module2.dto.UserPreference;
import com.example.Module2.service.MyKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
//    @Autowired
//    private  KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private  MyKafkaProducer myKafkaProducer;

//    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
    public KafkaController(MyKafkaProducer myKafkaProducer) {
        this.myKafkaProducer = myKafkaProducer;
    }

    @GetMapping("/send/message")
    public ResponseEntity<?> sendMessageToKafka(@RequestBody UserPreference message) {
        // Send the message to the Kafka topic
        //System.out.println("message : ");
        //kafkaTemplate.send("occ.flow-endpoint-correlator-ms.1", message);
        //USER-WISHLIST occ.flow-endpoint-correlator-ms.1
        myKafkaProducer.sendMessage("USER-WISHLIST", message);
        return ResponseEntity.ok("Message sent to Kafka for User : " + message.getId());

    }
    @PostMapping("/test")
    public String test(){
        return "test";
    }

}
