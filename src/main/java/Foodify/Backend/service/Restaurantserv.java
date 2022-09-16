package Foodify.Backend.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import Foodify.Backend.model.FoodCategory;
import Foodify.Backend.model.FoodItem;
import Foodify.Backend.model.FoodMenu;
import Foodify.Backend.exception.FoodMenuException;

public interface Restaurantserv {

	public ResponseEntity<Object> validate(String name,String name2,String username,String email);
	
	public String passwordEncorder(String userName,String email,String password, String accountStatus);
	
	public void updateContactDetails(String username);
	
	public FoodMenu addFoodMenu(FoodMenu foodMenu) throws FoodMenuException;

	public FoodCategory addFoodCategory(FoodCategory foodCategory) throws FoodMenuException;

	public FoodItem addFoodCategoryItem(FoodItem foodItem) throws FoodMenuException;

	public void init(String username);
	
	public void saveBanner(MultipartFile file,String username);
	
	public Resource loadBanner(String filename);
	
	public List<String> getItems(String items);

	public ResponseEntity<?> uploadOffer(String name,String description,String Bdate,String Edate,String discount,String itemList,MultipartFile file,String userName) throws IOException;

	public ResponseEntity<?> updateOffer(String name,String description,String Bdate,String Edate,String discount,String itemList,MultipartFile file,String userName,String offerId,String foodItems1) throws IOException;

	public List<FoodItem> getOfferFoods(String catId,String offerId);
	
	public List<String> getResComments(String rescomments);

	public FoodItem getOrderFood(String foodId);
}
