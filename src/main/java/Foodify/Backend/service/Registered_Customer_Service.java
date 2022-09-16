package Foodify.Backend.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import Foodify.Backend.exception.Registered_Customer_Exception;
import Foodify.Backend.exception.customFieldError;
import Foodify.Backend.exception.fieldErrorResponse;
import Foodify.Backend.model.Registered_Customer;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Registered_Customer_Service implements Registered_Customer_Sev{

	@Autowired
	private Foodify.Backend.repository.Registered_Customer_Repository RegCusRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Registered_Customer Login(String UserName, String Password) throws Registered_Customer_Exception {
		
		Optional<Registered_Customer> RegCusOptional = RegCusRepo.findByUser(UserName, Password);
		if (!RegCusOptional.isPresent()) {
			throw new Registered_Customer_Exception(Registered_Customer_Exception.NotFoundException());
		}else {
			return RegCusOptional.get();
		}
	}
	
////	--------------------------to get the user and grand authority------------------------------------------------------------
//	@Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String userName) {
//		
//		Registered_Customer user = RegCusRepo.findByUserName2(userName);
//        if (user == null) throw new UsernameNotFoundException(userName);
//
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        
//        grantedAuthorities.add(new SimpleGrantedAuthority(user.getaccountState()));
//        
//
//        return new org.springframework.security.core.userdetails.User(user.getuserName(), user.getpassword(), grantedAuthorities);
//    }
////	-------------------------end of getting user---------------------------------------------------------
	
	@Override
	public ResponseEntity<Object> validate(String name, String name2, String username, String email) {
		String error;
//		Integer count1 = 0;
		
//		---------------to check the userName-------------------------------------------------
		if(name == "userName") {
			
			System.out.println(username);
			Integer count1 = RegCusRepo.findByUserName(username); 
			System.out.println(email);
			if(count1 > 0) {
				error = "UserName already exists";
//				--------------call error response and add errors to custom field error list-----------
				fieldErrorResponse fieldErrorResponse = new fieldErrorResponse();
				List<customFieldError> fieldErrors = new ArrayList<>();
				customFieldError fieldError = new customFieldError();
				
	        	fieldError.setField("userName");
	        	fieldError.setMessage(error);
	        	fieldErrors.add(fieldError);
//	        	System.out.println(error);
	        	
	        	
//	        	adding final values to fieldErrorResponse and sending it as JSON object to front-end--------------
	        	fieldErrorResponse.setFieldErrors(fieldErrors);
//	        	return true;
	        	return new ResponseEntity<Object>(fieldErrorResponse, HttpStatus.BAD_REQUEST);
			}
		}
		if(name2 == "email"){
			Integer count2 = RegCusRepo.findByUserEmail(email); 
			System.out.println(count2);
			if(count2 > 0) {
				error = "Email already exists";
//				--------------call error response and add errors to custom field error list-----------
				fieldErrorResponse fieldErrorResponse = new fieldErrorResponse();
				List<customFieldError> fieldErrors = new ArrayList<>();
				customFieldError fieldError = new customFieldError();
				
	        	fieldError.setField("email");
	        	fieldError.setMessage(error);
	        	fieldErrors.add(fieldError);
//	        	System.out.println(error);
	        	
	        	
//	        	adding final values to fieldErrorResponse and sending it as JSON object to front-end--------------
	        	fieldErrorResponse.setFieldErrors(fieldErrors);
	        	return new ResponseEntity<Object>(fieldErrorResponse, HttpStatus.BAD_REQUEST);
			}
		}
		return null;
	}




	@Override
	public String passwordEncorder(String userName, String email, String password, String accountState) {
		// TODO Auto-generated method stub
		
		String epassword = passwordEncoder.encode(password);
		
		Registered_Customer user = new Registered_Customer();
		
		user.setuserName(userName);
		user.setEmail(email);
		user.setpassword(epassword);
		user.setaccountState(accountState);
		
		RegCusRepo.save(user);
		System.out.println(epassword);
		return null;
	}
	
	
//	--------------------------end of for validate userName and email--------------------------------------------
	
	

	//Reset Password
//	@Override
//	public void updateResetPasswordToken(String token, String email) throws Registered_Customer_Exception {
//
//		Registered_Customer RegCus = RegCusRepo.findByEmail(email);
//		if (RegCus == null) {
//			throw new Registered_Customer_Exception(Registered_Customer_Exception.NotFoundException());
//		}else {
//			RegCus.setResetPasswordToken(token);
//			RegCusRepo.save(RegCus);
//		}
//	}

//	@Override
//	public Registered_Customer getByResetPasswordToken(String token){
//		return RegCusRepo.findByResetPasswordToken(token);
//	}
//
//	@Override
//	public void updatePassword(Registered_Customer RegCus, String newPassword){
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String encodedPassword = passwordEncoder.encode(newPassword);
//
//		RegCus.setpassword(encodedPassword);
//
//		RegCus.setResetPasswordToken(null);
//		RegCusRepo.save(RegCus);
//	}


	//Reset Password
	@Override
	public void updateResetPasswordToken(String token, String email) throws Registered_Customer_Exception {

		Registered_Customer RegCus = RegCusRepo.findByEmail(email);
		if (RegCus == null) {
			throw new Registered_Customer_Exception(Registered_Customer_Exception.NotFoundException());
		}else {
			RegCus.setResetPasswordToken(token);
			RegCusRepo.save(RegCus);
		}
	}

	@Override
	public Registered_Customer getByResetPasswordToken(String token){
		return RegCusRepo.findByResetPasswordToken(token);
	}

	@Override
	public void updatePassword(Registered_Customer RegCus, String newPassword){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(newPassword);

		RegCus.setpassword(encodedPassword);

		RegCus.setResetPasswordToken(null);
		RegCusRepo.save(RegCus);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
