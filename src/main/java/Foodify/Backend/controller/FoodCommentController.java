package Foodify.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Foodify.Backend.model.FoodComment;
import Foodify.Backend.repository.FoodCommentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FoodCommentController {
	
	@Autowired
	private FoodCommentRepository foodCommentRepository;
	
	@PostMapping("/FoodiFy/User/addFoodComment")
	public FoodComment createComment(@RequestBody FoodComment Foodcomment) {
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(Foodcomment);

		System.out.println(userName);
//		String restauratId=commentRes.getRestaurantId();
//		String commentDescription=complain.getCommentDescription();
//		Date addedDate=complain.getAddedDate();
		
		Foodcomment.setUsername(userName);
		
		
		return foodCommentRepository.save(Foodcomment);
	}

}

