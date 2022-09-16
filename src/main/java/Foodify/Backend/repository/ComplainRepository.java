package Foodify.Backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import Foodify.Backend.model.Complain;

@Repository
public interface ComplainRepository extends MongoRepository<Complain,String> {
	@Query(value = "{complainStatus: ?0}", count = true)
	public long count2(String complainStatus);
	
}
