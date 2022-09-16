package Foodify.Backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import Foodify.Backend.model.Registered_Customer;
import Foodify.Backend.model.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String>{
	
//	@Query(sort= "{about:-1}")
//	public List<Restaurant> findlast();
	
	Restaurant findByuserName(String userName);
	Restaurant findByid(String id);

}
