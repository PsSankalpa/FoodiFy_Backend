package Foodify.Backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Foodify.Backend.model.Restaurant_About;

@Repository
public interface RestaurantAboutRepository extends MongoRepository<Restaurant_About,String> {
	
}
