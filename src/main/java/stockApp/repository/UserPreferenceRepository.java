package stockApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import stockApp.model.UserStockPreference;

public interface UserPreferenceRepository extends MongoRepository<UserStockPreference,String> {
}
