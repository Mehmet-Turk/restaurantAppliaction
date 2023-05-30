package com.application.service;

import com.application.model.Stock;
import com.application.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;

    @Override
    public Iterable<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<Stock> findById(long id) {
        return stockRepository.findById(id);
    }

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }


    @Override
    public void deleteById(long id) {
        stockRepository.deleteById(id);

    }
}

//    @Override
//    public Iterable<RestaurantTables> filterRestaurantTablesByAvailable(RestaurantTables restaurantTables) {
//        List<RestaurantTables> availableTables = (List<RestaurantTables>) restaurantTablesRepository.findAll();
//
////        String s1 = "Hello";
////        String s2 = null;
////        boolean check = s2 == null? true: s1.equals(s2);
//
//        return availableTables.stream()
//                .filter( x -> x.isAvailable() == restaurantTables.isAvailable())
//                .filter( x -> x.getTableId() == restaurantTables.getTableId())
////                .filter( x -> x.isVegan())
//                .toList();
//
//    }

//    @Override
//    public Iterable<RestaurantTables> filterRestaurantTablesByAvailable(boolean isAvailable) {
//        List<RestaurantTables> availableTables = (List<RestaurantTables>) restaurantTablesRepository.findAll();
//        return availableTables.stream().filter(x-> x.isAvailable()==isAvailable).toList();
//    }
//
//}
