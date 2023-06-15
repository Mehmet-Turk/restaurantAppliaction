package com.application.controller;

import com.application.model.MenuItem;
import com.application.model.Stock;
import com.application.repositories.MenuItemRepository;
import com.application.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("/api")
public class MenuItemController {
    @Autowired
    MenuItemRepository menuItemRepository;

    // Endpoint
    // http://localhost:8080/api/menu
    // POST
    @PostMapping(value = "menu", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MenuItem> createStock(@RequestBody MenuItem item){

        return ResponseEntity.ok().body(menuItemRepository.save(item));

    }

    // Endpoint
    // http://localhost:8080/api/menu
    // GET
    @GetMapping(value = "menu", produces = "application/json")
    public Iterable<MenuItem> getAllItems(){

        return menuItemRepository.findAll();


    }



    // Endpoint
    // http://localhost:8080/api/stock/2
    // GET
//    @GetMapping(value = "stock/{id}", produces = "application/json")
//    public ResponseEntity<Stock> getStockById(@PathVariable long id){
//        Optional<Stock> stock = stockService.findById(id);
//        return stock.isPresent()? ResponseEntity.ok().body(stock.get()):ResponseEntity.notFound().build();
////        if(reservation.isPresent()){
////            return ResponseEntity.ok().body(reservation.get());
////        }
////        return ResponseEntity.notFound().build();
//
//    }
    // Endpoint
    // http://localhost:8080/api/stock/filter
    // GET
//    @PostMapping(value = "tables/filter", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Iterable<RestaurantTables>> getAllAvailableTables(@RequestBody RestaurantTables restaurantTables){
//        return ResponseEntity.ok().body(
//                tableService.filterRestaurantTablesByAvailable(restaurantTables));
//    }
//    @GetMapping(value = "tables/filter/{isAvailable}", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Iterable<RestaurantTables>> getAllAvailableTables(@PathVariable boolean isAvailable){
//        return ResponseEntity.ok().body(
//                tableService.filterRestaurantTablesByAvailable(isAvailable));
//    }




        // Endpoint
    // http://localhost:8080/api/reservation/2
    // DEL
    @DeleteMapping("menu/{id}")
    public ResponseEntity<Void> deleteStockById( @PathVariable long id){

        menuItemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
