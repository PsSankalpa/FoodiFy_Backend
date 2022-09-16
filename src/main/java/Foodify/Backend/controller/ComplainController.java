package Foodify.Backend.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Foodify.Backend.model.Complain;
import Foodify.Backend.repository.ComplainRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ComplainController {
	
	@Autowired
	private ComplainRepository complainRepository;
//	public Complain createComplain(@RequestBody Complain complain,@RequestParam("Image")MultipartFile file) throws IOException {
	@PostMapping("/FoodiFy/User/addComplains")

    public ResponseEntity<?> uploadcomplaindetails(
    		@RequestParam("Image")MultipartFile file,
    		@RequestParam("restauratId") String name1,
    		@RequestParam("complainTitle") String name2,
    		@RequestParam("complainDescription") String name3,
    		@RequestParam("complainStatus") String name4,
    		@RequestParam("addedDate") String name5) throws IOException {

		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
//		System.out.println(complain);

		System.out.println(userName);
		
		Complain complain = new Complain();
		complain.setRestaurantId(name1);
		complain.setComplainTitle(name2);
		complain.setComplainDescription(name3);
		complain.setComplainStatus(name4);
		complain.setAddedDate(name5);
		complain.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		complainRepository.save(complain);
		return null;

	}


	
	
	@GetMapping("/FoodiFy/User/getCount/pending")
	public int showComplainspending() {
		String state = "pending";
		int complains = (int) complainRepository.count2(state);
//		List<Complain> complainList = new ArrayList<Complain>();

//		System.out.println(complainList);
		return complains;
	}
	
	
	@GetMapping("/FoodiFy/User/getCount/accepted")
	public int showComplainsaccepted() {
		String state = "accepted";
		int complains = (int) complainRepository.count2(state);
//		List<Complain> complainList = new ArrayList<Complain>();
//		System.out.println(complainList);
		return complains;
	}
	
	@GetMapping("/FoodiFy/User/getCount/rejected")
	public int showComplainsrejected() {
		String state = "rejected";
		int complains = (int) complainRepository.count2(state);
//		List<Complain> complainList = new ArrayList<Complain>();
//		System.out.println(complainList);
		return complains;
	}
	
	@GetMapping("/FoodiFy/User/getCount/complainhistory")
	public List<Complain> complainhistory() {
		List<Complain> complains = complainRepository.findAll();
		
		return complains;
	}

}
