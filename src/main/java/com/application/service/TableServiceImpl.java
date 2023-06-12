package com.application.service;

import com.application.model.Reservation;
import com.application.model.RestaurantTables;
import com.application.repositories.RestaurantTablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public Iterable<RestaurantTables> filterRestaurantTablesByAvailable(RestaurantTables restaurantTables) {
        List<RestaurantTables> availableTables = (List<RestaurantTables>) restaurantTablesRepository.findAll();

//        String s1 = "Hello";
//        String s2 = null;
//        boolean check = s2 == null? true: s1.equals(s2);

        return availableTables.stream()
                .filter( x -> x.isAvailable() == restaurantTables.isAvailable())
                .filter( x -> x.getTableId() == restaurantTables.getTableId())
//                .filter( x -> x.isVegan())
                .toList();

    }

    @Override
    public Iterable<RestaurantTables> filterRestaurantTablesByAvailable(boolean isAvailable) {
        List<RestaurantTables> availableTables = (List<RestaurantTables>) restaurantTablesRepository.findAll();
        return availableTables.stream().filter(x-> x.isAvailable()==isAvailable).toList();
    }

}
