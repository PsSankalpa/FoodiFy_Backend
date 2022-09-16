package Foodify.Backend.controller;

import Foodify.Backend.model.FoodItem;
import Foodify.Backend.model.OrderItem;
import Foodify.Backend.model.ShoppingCart;
import Foodify.Backend.repository.FoodItem_Repository;
import Foodify.Backend.repository.ShoppingCart_Repository;
import Foodify.Backend.service.ShopCartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ShoppingCartController {

    @Autowired
    private ShoppingCart_Repository ShoppingCartRepo;

    @Autowired
    private ShopCartServiceImp ShopCartService;

    @Autowired
    private FoodItem_Repository foodItem_repository;



    @PostMapping("/FoodiFy/Service/setShoppingCart")
    public ResponseEntity<?> setShoppingCart(@RequestBody OrderItem orderItem) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
//        int price = orderItem.getPrice();

//        System.out.println(orderItem.getFoodId());
//        System.out.println(orderItem.getRestaurantId());
        int price = orderItem.getPrice();

        try {

            return new ResponseEntity<>(ShopCartService.setShoppingCart(userName,orderItem,price), HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
//        return null;

    }
    @GetMapping("/FooddiFy/Service/getShoppingCart")
    public ResponseEntity<?> getShoppingCart(){

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        try {

            return new ResponseEntity<>(ShopCartService.setCartitems(userName), HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }

//        return null;
    }

}
