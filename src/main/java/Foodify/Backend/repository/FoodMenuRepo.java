package Foodify.Backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import Foodify.Backend.model.FoodMenu;


@Repository
public interface FoodMenuRepo extends MongoRepository<FoodMenu,String>{
    
    @Query("{userName: ?0}")
	Optional<FoodMenu> findByResturantMenuExists(String userName);

    List<FoodMenu> findByuserName(String userName);
    
}
