package com.application.service;

import com.application.model.RestaurantOrders;
import com.application.repositories.RestaurantOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RestaurantOrdersServiceImpl implements RestaurantOrdersService{
    @Autowired
    RestaurantOrdersRepository restaurantOrdersRepository;
    @Override
    public Iterable<RestaurantOrders> findAll() {
        return restaurantOrdersRepository.findAll();
    }

    @Override
    public Optional<RestaurantOrders> findById(long id) {
        return restaurantOrdersRepository.findById(id);
    }

    @Override
    public RestaurantOrders save(RestaurantOrders order) {
        return restaurantOrdersRepository.save(order);
    }

    @Override
    public void deleteById(long id) {
        restaurantOrdersRepository.deleteById(id);

    }
}
