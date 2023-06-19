package com.application.service;

import com.application.model.MenuItem;
import com.application.model.RestaurantOrders;
import com.application.repositories.MenuItemRepository;
import com.application.repositories.RestaurantOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RestaurantOrdersServiceImpl implements RestaurantOrdersService{
    @Autowired
    RestaurantOrdersRepository restaurantOrdersRepository;
    @Autowired
    MenuItemRepository menuItemRepository;
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
//        List<MenuItem> menus = (List<MenuItem>) menuItemRepository.findAll();
//        RestaurantOrders restaurantOrders = new RestaurantOrders(menus);
//        order.setMenuItem(menus);
//        RestaurantOrders savedOrder = restaurantOrdersRepository.save(order);
//        return savedOrder;
        return restaurantOrdersRepository.save(order);
    }

    @Override
    public void deleteById(long id) {
        restaurantOrdersRepository.deleteById(id);

    }
}
