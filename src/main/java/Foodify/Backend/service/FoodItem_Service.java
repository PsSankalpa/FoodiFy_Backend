package Foodify.Backend.service;
import Foodify.Backend.model.FoodItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodItem_Service {

	List<FoodItem> findByRes(String ResId);
	
	
}
