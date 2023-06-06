package com.application.controller;

import com.application.model.RestaurantOrders;
import com.application.model.RestaurantTables;
import com.application.service.RestaurantOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestaurantOrderController {
    @Autowired
    RestaurantOrdersService restaurantOrdersService;
    // Endpoint
    // http://localhost:8080/api/orders
    // GET
    @GetMapping(value = "orders", produces = "application/json")
    public Iterable<RestaurantOrders> getAllOrders(){
        return restaurantOrdersService.findAll();
    }
}
