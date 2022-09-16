package Foodify.Backend.repository;

import Foodify.Backend.model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCart_Repository extends MongoRepository<ShoppingCart,String> {

    ShoppingCart findByuserName(String userName);
}
