
package Foodify.Backend.repository;

import Foodify.Backend.model.Order;
import Foodify.Backend.model.Registered_Customer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Order_Repository extends MongoRepository<Order, String> {


	
	@Query(value ="{user: ObjectId(?0)}")
	List<Order> findByUser(String UserId);

//	@Query(value ="{restaurant: ?0}")
//	List<Order> findByRes(ObjectId RestaurantId);
	
}



