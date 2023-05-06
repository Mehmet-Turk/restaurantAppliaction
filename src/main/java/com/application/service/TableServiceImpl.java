package com.application.service;

import com.application.model.RestaurantTables;
import com.application.repositories.RestaurantTablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableServiceImpl implements TableService{
    @Autowired
    RestaurantTablesRepository restaurantTablesRepository;
    @Override
    public Iterable<RestaurantTables> findAll() {
        return restaurantTablesRepository.findAll();
    }

    @Override
    public Optional<RestaurantTables> findById(long id) {
        return restaurantTablesRepository.findById(id);
    }

    @Override
    public RestaurantTables save(RestaurantTables table) {
        return restaurantTablesRepository.save(table);
    }



    @Override
    public void deleteById(long id) {
        restaurantTablesRepository.deleteById(id);

    }
}
