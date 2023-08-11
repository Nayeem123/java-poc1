package stockApp.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "user-stock-preference")
public class UserStockPreference implements Deserializer<UserStockPreference> {
    String id;
    String operation;
    String watchList;
    List<String> stockName;

    @Override
    public UserStockPreference deserialize(String s, byte[] data) {
        final ObjectMapper objectMapper = new ObjectMapper();

        try {
            if (data == null) {
                // Handle the case when the message value is null
                return null;
            }
            // Deserialize the byte array data back to a Person object
            return objectMapper.readValue(data, UserStockPreference.class);
        } catch (Exception e) {
            // Handle deserialization errors appropriately
            e.printStackTrace();
            return null;
        }
    }
}
