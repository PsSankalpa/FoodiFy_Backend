package Foodify.Backend.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import Foodify.Backend.request.AuthenticationRequest;
import Foodify.Backend.service.UserService;
import Foodify.Backend.util.JwtUtil;
import Foodify.Backend.Response.LoginResponse;
import Foodify.Backend.Response.UserInfo;
import Foodify.Backend.model.AuthenticationResponse;
import Foodify.Backend.model.Registered_Customer;
import Foodify.Backend.repository.UserRepository;

@RestController
@RequestMapping("/FoodiFy")
@CrossOrigin (origins = "http://localhost:3000")
public class AuthenticationController {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auth/login")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest){
		
		String userName = authenticationRequest.getUserName();
		String password = authenticationRequest.getPassword();
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
		}catch(Exception e) {
			
			return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
		}
		
		UserDetails loadedUser = userService.loadUserByUsername(userName);
		
		String name = loadedUser.getUsername();
//		System.out.println(name);
		
//		-----------------newly added--1.08.39-NI------------------------------------------
//		Registered_Customer user = (Registered_Customer) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password)).getPrincipal();
		String generatedToken = jwtUtil.generateToken(name);
		
		LoginResponse response = new LoginResponse();
		response.setToken(generatedToken);
				
		return ResponseEntity.ok(response);
//		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
		
	}
	
	@GetMapping("/testing")
	private String Testing() {
		return "Welcome to dashboard" +" "+ SecurityContextHolder.getContext().getAuthentication().getName();
		
	}
	
//	@PreAuthorize("hasaccountState('MODERATOR') or hasaccountState('ADMIN')")
//	--------------1.13.50---------------
	@GetMapping("/auth/userinfo")
	private ResponseEntity<?> userInfo(Principal user) {
		
//		---------1.13.55---------
//		Registered_Customer loadUser = new Registered_Customer();
//		Registered_Customer loadUser = (Registered_Customer) userService.loadUserByUsername(user.getName());
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<? extends GrantedAuthority> role = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(username);
		userInfo.setRoles(role);
		
//		Registered_Customer foundUser = userRepository.findByuserName(userName);
		return ResponseEntity.ok(userInfo);
		
//		-----------1.20.08-------------------------------------------
		
	}

}


//@Autowired
//private AuthenticationManager authenticationManager;
//
//@Autowired
//private UserDetailsService userDetailsServise;
//
//@Autowired
//JWTTokenHelper jWTTokenHelper;
//
//@PostMapping("/auth/login")
//public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException{
////	
//	final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//			authenticationRequest.getUserName(), authenticationRequest.getPassword()));
//	
//	SecurityContextHolder.getContext().setAuthentication(authentication);
//	
//	User user=(User)authentication.getPrincipal();
//	
//	String jwtToken=jWTTokenHelper.generateToken(user.getUsername());
//	
//	LoginResponse response=new LoginResponse();
//	response.setToken(jwtToken);
//	
//	return ResponseEntity.ok(response);
//	
//}
