package stockApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import stockApp.model.UserStockPreference;

@Service
public class KafkaConsumer {


    @Autowired
    private PerformOperationOnStockName stockWatchListOperation;

    @KafkaListener(topics = "USER-WISHLIST", groupId = "userPreference-consumer-group")
    public void receiveMessage(UserStockPreference userStockPreference) throws JsonProcessingException {
        // Process the received message
        ObjectMapper mapper = new ObjectMapper();

       System.out.println("Received message: "+mapper.writeValueAsString(userStockPreference));
       stockWatchListOperation.doOperation(userStockPreference);
    }

}
