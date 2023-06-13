package com.application.controller;

import com.application.model.RestaurantTables;
import com.application.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("/api")
public class TableController {
    @Autowired
    TableService tableService;

    // Endpoint
    // http://localhost:8080/api/table
    // POST
    @PostMapping(value = "table", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RestaurantTables> createTable(@RequestBody RestaurantTables table){

        return ResponseEntity.ok().body(tableService.save(table));

    }

    // Endpoint
    // http://localhost:8080/api/table
    // GET
    @GetMapping(value = "table", produces = "application/json")
    public Iterable<RestaurantTables> getAllTables(){

        return tableService.findAll();


    }

    // Endpoint
    // http://localhost:8080/api/reservation/filter/true
    // GET


    // Endpoint
    // http://localhost:8080/api/table/2
    // GET
    @GetMapping(value = "table/{id}", produces = "application/json")
    public ResponseEntity<RestaurantTables> getTableById(@PathVariable long id){
        Optional<RestaurantTables> table = tableService.findById(id);
        return table.isPresent()? ResponseEntity.ok().body(table.get()):ResponseEntity.notFound().build();
//        if(reservation.isPresent()){
//            return ResponseEntity.ok().body(reservation.get());
//        }
//        return ResponseEntity.notFound().build();

    }
    // Endpoint
    // http://localhost:8080/api/table/filter
    // GET
    @PostMapping(value = "table/filter", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Iterable<RestaurantTables>> getAllAvailableTables(@RequestBody RestaurantTables restaurantTables){
        return ResponseEntity.ok().body(
                tableService.filterRestaurantTablesByAvailable(restaurantTables));
    }
    //http://localhost:8080/api/table/filter/true
    @GetMapping(value = "table/filter/{isAvailable}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Iterable<RestaurantTables>> getAllAvailableTables(@PathVariable boolean isAvailable){
        return ResponseEntity.ok().body(
                tableService.filterRestaurantTablesByAvailable(isAvailable));
    }




        // Endpoint
    // http://localhost:8080/api/reservation/2
    // DEL
    @DeleteMapping("table/{id}")
    public ResponseEntity<Void> deleteTableById( @PathVariable long id){

        tableService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
