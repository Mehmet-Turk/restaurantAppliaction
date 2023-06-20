package com.application.service;

import com.application.model.RestaurantOrders;
import com.application.model.RestaurantTables;

import java.util.List;
import java.util.Optional;

public interface RestaurantOrdersService {
    Iterable<RestaurantOrders> findAll();
    Optional<RestaurantOrders> findById(long id);
    RestaurantOrders save(RestaurantOrders order);
    void deleteById( long id);
    List<RestaurantOrders> getTableOrders(RestaurantOrders orders);
}
