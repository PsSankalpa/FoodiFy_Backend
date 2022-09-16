package Foodify.Backend.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import Foodify.Backend.model.Registered_Customer;

public interface UserRepository extends MongoRepository<Registered_Customer, String> {

	Registered_Customer findByuserName(String userName);

};