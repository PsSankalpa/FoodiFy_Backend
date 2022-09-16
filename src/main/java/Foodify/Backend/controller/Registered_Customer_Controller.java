
package Foodify.Backend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import Foodify.Backend.repository.Registered_Customer_Repository;
import Foodify.Backend.exception.Registered_Customer_Exception;
import Foodify.Backend.exception.fieldErrorResponse;
import Foodify.Backend.model.Registered_Customer;
import Foodify.Backend.service.Registered_Customer_Sev;

//using cross origin annotation to communicate with react.js and spring

@RestController
@CrossOrigin (origins = "http://localhost:3000")
public class Registered_Customer_Controller {

	@Autowired
	private Registered_Customer_Sev RegCusServ;
	
	@Autowired
	private Registered_Customer_Repository RegCusRepo;
	
	
	@GetMapping("/Foodify/{Username}/{Password}")
	public ResponseEntity<?> Login(@PathVariable("Username") String Username, @PathVariable("Password") String Password ){
	
		try {
			return new ResponseEntity<>(RegCusServ.Login(Username, Password), HttpStatus.OK);
		}
		catch(Registered_Customer_Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	fieldErrorResponse fieldErrorResponse = new fieldErrorResponse();
	
//	-----------------------------------------create method-------------------------------------------------------------------
//	----------to response entity, use response object----------
	@PostMapping("/Register/Signupuser")
	public ResponseEntity<?> createUser(@Valid @RequestBody Registered_Customer registeredCustomer) {
		
//		RegCusRepo.save(registeredCustomer);
		
		
//		RegCusServ service = new RegCusServ();
		
		ResponseEntity<Object> count = RegCusServ.validate("userName", "email",registeredCustomer.getuserName() , registeredCustomer.getEmail());
		
		String userName = registeredCustomer.getuserName();
		String email = registeredCustomer.getEmail();
		String password = registeredCustomer.getpassword();
		String accountState = registeredCustomer.getaccountState();


//		--------------------sending data to db if there is no errors--------------------------------------------
		if(count == null) {
			RegCusServ.passwordEncorder(userName, email, password, accountState);
//			RegCusRepo.save(registeredCustomer);
		}
//		RegCusRepo.find();
//		 System.out.println(data);
		return count;				
	}
//	----------------end of create method-----------------------------------------------------------------------------------------
	

//	-----------------------------------------create method-------------------------------------------------------------------
//	----------to response entity, use response object----------
	@PostMapping("/Register/Signuppremiumuser")
	public ResponseEntity<?> createPremiumUser(@Valid @RequestBody Registered_Customer registeredCustomer) {
		
//		RegCusRepo.save(registeredCustomer);
		
		
//		RegCusServ service = new RegCusServ();
		
		ResponseEntity<Object> count = RegCusServ.validate("userName", "email",registeredCustomer.getuserName() , registeredCustomer.getEmail());
		
		String userName = registeredCustomer.getuserName();
		String email = registeredCustomer.getEmail();
		String password = registeredCustomer.getpassword();
		String accountState = registeredCustomer.getaccountState();


//		--------------------sending data to db if there is no errors--------------------------------------------
		if(count == null) {
			RegCusServ.passwordEncorder(userName, email, password, accountState);
//			RegCusRepo.save(registeredCustomer);
		}
//		RegCusRepo.find();
//		 System.out.println(data);
		return count;				
	}
//	----------------end of create method-----------------------------------------------------------------------------------------
	

	





	


	
//	----------------------------de_activate method-------------------------------------------------------------------------------
//	@PostMapping("/user/deactivate/{id}")
//	public void deacivateUser(@PathVariable String id) {
//		
//	}
//	
////	show details method
//	@GetMapping
//	public void showUserDetails() {
//		
//	}
}