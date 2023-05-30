package com.application.controller;

import com.application.model.RestaurantTables;
import com.application.model.Stock;
import com.application.service.StockService;
import com.application.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("/api")
public class StockController {
    @Autowired
    StockService stockService;

    // Endpoint
    // http://localhost:8080/api/stock
    // POST
    @PostMapping(value = "stock", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock){

        return ResponseEntity.ok().body(stockService.save(stock));

    }

    // Endpoint
    // http://localhost:8080/api/stock
    // GET
    @GetMapping(value = "stock", produces = "application/json")
    public Iterable<Stock> getAllStocks(){

        return stockService.findAll();


    }



    // Endpoint
    // http://localhost:8080/api/stock/2
    // GET
    @GetMapping(value = "stock/{id}", produces = "application/json")
    public ResponseEntity<Stock> getStockById(@PathVariable long id){
        Optional<Stock> stock = stockService.findById(id);
        return stock.isPresent()? ResponseEntity.ok().body(stock.get()):ResponseEntity.notFound().build();
//        if(reservation.isPresent()){
//            return ResponseEntity.ok().body(reservation.get());
//        }
//        return ResponseEntity.notFound().build();

    }
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
    @DeleteMapping("stock/{id}")
    public ResponseEntity<Void> deleteStockById( @PathVariable long id){

        stockService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
