package Foodify.Backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import Foodify.Backend.exception.Registered_Customer_Exception;
import Foodify.Backend.model.Registered_Customer;

public interface Registered_Customer_Sev {

	public Registered_Customer Login(String UserName,String Password ) throws Registered_Customer_Exception;
	
	public UserDetails loadUserByUsername(String userName);
	
	public ResponseEntity<Object> validate(String name,String name2,String username,String email);
	
	public String passwordEncorder(String userName,String email,String password,String accountState);


	public void updateResetPasswordToken(String token, String email) throws Registered_Customer_Exception;
	public Registered_Customer getByResetPasswordToken(String token);
	public void updatePassword(Registered_Customer RegCus, String newPassword);


	
}
