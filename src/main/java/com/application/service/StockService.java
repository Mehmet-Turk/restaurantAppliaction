package com.application.service;

import com.application.model.Stock;

import java.util.Optional;

public interface StockService {
    Iterable<Stock> findAll();
    Optional<Stock> findById(long id);
    Stock save(Stock stock);
    void deleteById( long id);
//    Iterable<RestaurantTables> filterRestaurantTablesByAvailable(RestaurantTables restaurantTables);
//    Iterable<RestaurantTables> filterRestaurantTablesByAvailable(boolean isAvailable);

}
