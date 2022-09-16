package Foodify.Backend.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Foodify.Backend.model.Registered_Customer;
import Foodify.Backend.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Registered_Customer foundUser = userRepository.findByuserName(userName);
		
		if(foundUser==null) return null;
		
		String username = foundUser.getuserName();
		String password = foundUser.getpassword();
		String role = foundUser.getaccountState();
		
		List<String> list = new ArrayList<>();
		list.add(role);
		
		List<GrantedAuthority> authorities = getUserAuthority(foundUser.getaccountState());
		
		
		return new User(username,password,authorities);
	}
	
	private List<GrantedAuthority> getUserAuthority(String getaccountState) {
		// TODO Auto-generated method stub
		Set<GrantedAuthority> roles = new HashSet<>();
		
	        roles.add(new SimpleGrantedAuthority(getaccountState));
	
	
	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
	    return grantedAuthorities;
	}

}
