package Foodify.Backend.controller;

import Foodify.Backend.model.Restaurant;
import Foodify.Backend.repository.RestaurantRepository;
import Foodify.Backend.service.Restaurantserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RestaurantInfo")
@CrossOrigin (origins = "http://localhost:3000")
public class RestaurantInfoController {

    @Autowired
    private RestaurantRepository resRepo;

    @PostMapping("/editContact")
    public boolean editContact(@RequestBody Restaurant restaurantInfo) {
		resRepo.save(restaurantInfo);
        return true;
    }

    @PostMapping("/editAbout")
    public boolean editAbout(@RequestBody Restaurant restaurantAbout) {
        resRepo.save(restaurantAbout);
        return true;
    }

}
