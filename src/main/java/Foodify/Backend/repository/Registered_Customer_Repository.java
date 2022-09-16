
package Foodify.Backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import Foodify.Backend.model.Registered_Customer;

@Repository
public interface Registered_Customer_Repository extends MongoRepository<Registered_Customer, String> {
	
	@Query("{'$and':[ {'userName': ?0}, {'password':?1} ] }")
	Optional<Registered_Customer> findByUser(String UserName, String Password);

	//Reset Password
//	@Query("{'email': {'$regex':?0,$options: i}}")
//	Registered_Customer findByEmail(String email);
//
//	Registered_Customer findByResetPasswordToken(String token);
	
	@Query(value = "{ 'status' : ?0 }", fields = "{ 'item' : 1, 'status' : 1 }")
    List<Registered_Customer> findByStatusIncludeItemAndStatusFields(String status);
    
    @Query(value ="{userName: ?0}", count=true)               
    public Integer findByUserName(String userName);
    
    @Query(value ="{email: ?0}", count=true)                
    public Integer findByUserEmail(String email);
	
	@Query("{userName:'?0'}")
	Optional<Registered_Customer> findByUsername(String UserName);
	
	//Reset Password
	@Query("{'email': ?0}")
	Registered_Customer findByEmail(String email);

	Registered_Customer findByResetPasswordToken(String token);
	
	Registered_Customer findByuserName(String userName);
}



