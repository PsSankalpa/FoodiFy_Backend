package Foodify.Backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Foodify.Backend.model.FoodComment;

@Repository
public interface FoodCommentRepository extends MongoRepository<FoodComment,String> {

}