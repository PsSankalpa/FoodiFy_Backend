package Foodify.Backend.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Foodify.Backend.model.Offers;
import Foodify.Backend.model.Restaurant;
import Foodify.Backend.model.RestaurantComments;
import Foodify.Backend.repository.RestaurantCommentRepository;
import Foodify.Backend.repository.RestaurantRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RestaurantCommentController {
	
	@Autowired
	private RestaurantCommentRepository restaurantCommentRepository;
	
	@Autowired
	private RestaurantRepository restaurantrepo;
	
	@PostMapping("/FoodiFy/User/addRestaurantComment")
	public RestaurantComments createComment(@RequestBody RestaurantComments Rescomment) {
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(Rescomment);

		System.out.println(userName);
//		String restauratId=commentRes.getRestaurantId();
//		String commentDescription=complain.getCommentDescription();
//		Date addedDate=complain.getAddedDate();
		
		Rescomment.setUsername(userName);
		
		
		return restaurantCommentRepository.save(Rescomment);
	}
	
	/* -------------------------------- Get Res Comments Customer view -------------------------------- */
	@PostMapping("/FoodiFy/Service/getRestaurantCommentC")
	public List<RestaurantComments> getRestaurantComment(@RequestParam("id") String id) {
		
		Restaurant restaurant = restaurantrepo.findByid(id);
		String userName = restaurant.getUserName();

		List<RestaurantComments> items = restaurantCommentRepository.findByuserName(userName);
		List<RestaurantComments> restaurantCommentList = new ArrayList<RestaurantComments>();
//		--------------------setting relevant data for output------------------------
		for(int i = 0; i<items.size();i++) {
			RestaurantComments restaurantComment = new RestaurantComments();			
			restaurantComment.setUsername(items.get(i).getUsername());
			restaurantComment.setCommentDescription(items.get(i).getCommentDescription());
			restaurantComment.setId(items.get(i).getId());			
			restaurantCommentList.add(restaurantComment);
		}
		return restaurantCommentList;
	}
	
	/* -------------------------------- Get Res Comments restaurant view -------------------------------- */
	@GetMapping("/FoodiFy/Service/getRestaurantComment/{id}")
	public RestaurantComments getRestaurantComments(@PathVariable(value="id") String id) {

		RestaurantComments restaurantComment = restaurantCommentRepository.findByid(id);


		return restaurantComment;
	}
	
	/* -------------------------------- Get Res Comments view -------------------------------- */
	@GetMapping("/FoodiFy/Restaurant/getRestaurantCommentR")
	public List<RestaurantComments> getRestaurantComment2() {

		String userName = SecurityContextHolder.getContext().getAuthentication().getName();	
		List<RestaurantComments> items = restaurantCommentRepository.findByuserName(userName);
		List<RestaurantComments> restaurantCommentList = new ArrayList<RestaurantComments>();
//		--------------------setting relevant data for output------------------------
		for(int i = 0; i<items.size();i++) {
			RestaurantComments restaurantComment = new RestaurantComments();			
			restaurantComment.setUsername(items.get(i).getUsername());
			restaurantComment.setCommentDescription(items.get(i).getCommentDescription());
			restaurantComment.setId(items.get(i).getId());			
			restaurantCommentList.add(restaurantComment);
		}
		return restaurantCommentList;
	}

}
