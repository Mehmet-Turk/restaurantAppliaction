package com.application.controller;

import com.application.model.MenuItem;
import com.application.model.Reservation;
import com.application.model.RestaurantOrders;
import com.application.model.RestaurantTables;
import com.application.service.MenuItemService;
import com.application.service.RestaurantOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestaurantOrderController {
    @Autowired
    RestaurantOrdersService restaurantOrdersService;
    @Autowired
    MenuItemService menuItemService;

    // Endpoint
    // http://localhost:8080/api/orders
    // POST
    @PostMapping(value = "/orders", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RestaurantOrders> createReservation(@RequestBody RestaurantOrders restaurantOrders) {
//        List<MenuItem> menus = restaurantOrders.getMenuItem();
//
//        for (MenuItem menu : menus) {
//            String name = menu.getItemName();
//            double price = menu.getPrice();
//            menu.setItemName(name);
//            menu.setPrice(price);
//
//        }
        return ResponseEntity.ok().body(restaurantOrdersService.save(restaurantOrders));

    }
    // Endpoint
    // http://localhost:8080/api/orders
    // GET
    @GetMapping(value = "orders", produces = "application/json")
    public Iterable<RestaurantOrders> getAllOrders() {
        return restaurantOrdersService.findAll();
    }

    // Endpoint
    // http://localhost:8080/api/orders/2
    // GET
    @GetMapping(value = "orders/{id}", produces = "application/json")
    public ResponseEntity<RestaurantOrders> getOrdersById(@PathVariable long id) {
        Optional<RestaurantOrders> order = restaurantOrdersService.findById(id);
        return order.isPresent() ? ResponseEntity.ok().body(order.get()) : ResponseEntity.notFound().build();
//        if(reservation.isPresent()){
//            return ResponseEntity.ok().body(reservation.get());
//        }
//        return ResponseEntity.notFound().build();

    }

    // Endpoint
    // http://localhost:8080/api/orders/2
    // DEL
    @DeleteMapping("orders/{id}")
    public ResponseEntity<Void> deleteReservationById(@PathVariable long id) {

        restaurantOrdersService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}