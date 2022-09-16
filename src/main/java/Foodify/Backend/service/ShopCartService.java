package Foodify.Backend.service;

import Foodify.Backend.model.OrderItem;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ShopCartService {

    public ResponseEntity<?> setShoppingCart(String userName, OrderItem orderItem,int price);

    public Map setCartitems(String userName);
}
