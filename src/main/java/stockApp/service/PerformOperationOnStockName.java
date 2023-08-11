package stockApp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stockApp.model.UserStockPreference;
import stockApp.repository.UserPreferenceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PerformOperationOnStockName {
    private static final String ADD_STOCK = "ADD";
    private static final String DELETE_STOCK = "DELETE";

    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    public void doOperation(UserStockPreference userStockPreference) {
        if(userStockPreference.getOperation().equalsIgnoreCase(ADD_STOCK)){
            addStock(userStockPreference);
        }
        if(userStockPreference.getOperation().equalsIgnoreCase(DELETE_STOCK)){
            deleteStock(userStockPreference);
        }
    }
    private void addStock(UserStockPreference userStockPreference) {

        if(!userPreferenceRepository.existsById(userStockPreference.getId())){
            userPreferenceRepository.save(userStockPreference);
            log.info("User with id " + userStockPreference.getId() + " Added ");
        }
        else {
            Optional<UserStockPreference> userStockPreference1=
                    userPreferenceRepository.findById(userStockPreference.getId());
            UserStockPreference userStockPreference2 = new UserStockPreference();
            userStockPreference2.setId(userStockPreference1.get().getId());
            List<String> updateStockList = new ArrayList<>();
            ArrayList<String> newList = new ArrayList<String>();
            System.out.println(userStockPreference.getStockName());
            System.out.println(userStockPreference1.get().getStockName());
            userStockPreference2.setStockName(userStockPreference.getStockName());
            // Traverse through the first list
            for (String element : userStockPreference1.get().getStockName()) {

                // If this element is not present in newList
                // then add it
                if (!userStockPreference2.getStockName().contains(element)) {

                    userStockPreference2.getStockName().add(element);
                }
            }
            System.out.println(userStockPreference2.getStockName());
            //updateStockList.add(userStockPreference1.get().getStockName().toString());
            //updateStockList.add(userStockPreference.getStockName().toString());
            userStockPreference2.setWatchList(userStockPreference1.get().getWatchList());
            //userStockPreference2.setOperation(userStockPreference.getOperation());
            userPreferenceRepository.save(userStockPreference2);
            log.info("User with id " + userStockPreference.getId() + " Updated with stockList "+updateStockList);
        }

    }
    private void deleteStock(UserStockPreference userStockPreference) {

    }


}
