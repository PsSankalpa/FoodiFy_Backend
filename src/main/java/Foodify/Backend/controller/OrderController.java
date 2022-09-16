package Foodify.Backend.controller;

import Foodify.Backend.model.Order;
import Foodify.Backend.repository.Order_Repository;
import Foodify.Backend.service.Order_Service;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderController {

    @Autowired
    private Order_Repository order_repository;

    @Autowired(required = false) //error debugged by false
    private Order_Service order_service;

    @GetMapping("/FoodiFy/User/Orders/{userId}")
    public List<Order> ordersByUser(@PathVariable String userId){
        List<Order> detailed =  order_service.getDetailedOrders(userId);
//        List<Order> detailed =  order_repository.findByUser(userId);
        return detailed;
    }

    @GetMapping("Foodify/Admin/Orders/All")
    public List<Order> ordersAll(){
        List<Order> detailed =  order_service.getDetailedOrders();
//        List<Order> detailed =  order_repository.findByUser(userId);
        return detailed;
    }



}
