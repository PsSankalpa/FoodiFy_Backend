
package Foodify.Backend.repository;

import Foodify.Backend.model.FoodItem;
import Foodify.Backend.model.Offers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodItem_Repository extends MongoRepository<FoodItem, String> {

	FoodItem findByid(String id);
	
	@Query(value ="{restaurant: ?0}", count=true)
	List<FoodItem> findByRes(String ResId);

	@Query("{'$and':[ {'catId': ?0}, {'name':?1} ] }")
	Optional<FoodItem> findByMenuCategoryItemExists(String catId, String name);

	@Query(value ="{catId: ?0}", count=true)
	List<FoodItem> findByMenuCategoryItem(String catId);
	
	
	List<FoodItem> findBycatId(String catId);
		
}



