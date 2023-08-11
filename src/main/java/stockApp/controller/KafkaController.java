package stockApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This is just for test purpose -----
@RestController
@RequestMapping("/kafka")
public class KafkaController {
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessageToKafka(@RequestBody String message) {
        // Send the message to the Kafka topic
       // kafkaTemplate.send("occ.flow-endpoint-correlator-ms.1", message);

        return ResponseEntity.ok("Message sent to Kafka: " + message);
    }

}
