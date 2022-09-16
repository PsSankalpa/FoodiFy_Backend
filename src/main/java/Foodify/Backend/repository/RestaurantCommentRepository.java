package Foodify.Backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Foodify.Backend.model.Offers;
import Foodify.Backend.model.RestaurantComments;

@Repository
public interface RestaurantCommentRepository extends MongoRepository<RestaurantComments,String> {
	
	RestaurantComments findByid(String id);
	
	List<RestaurantComments> findByuserName(String userName);

}