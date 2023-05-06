package com.application.service;

import com.application.model.RestaurantTables;

import java.util.Optional;

public interface TableService {
    Iterable<RestaurantTables> findAll();
    Optional<RestaurantTables> findById(long id);
    RestaurantTables save(RestaurantTables table);
    void deleteById( long id);
}
