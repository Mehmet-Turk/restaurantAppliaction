package com.application.service;

import com.application.model.MenuItem;
import com.application.model.RestaurantOrders;
import com.application.repositories.MenuItemRepository;
import com.application.repositories.RestaurantOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
//        String itemName = order.getItemName();
//        List<MenuItem> menuOrder = new ArrayList<>();
//        List<MenuItem> menus = (List<MenuItem>) menuItemRepository.findAll();
//        for(MenuItem item:menus){
//            if (itemName.equals(item.getItemName())){
//                menuOrder.add(item);
//                order.setMenuItem(menuOrder);
//            }
//        }
        return restaurantOrdersRepository.save(order);
    }

    @Override
    public void deleteById(long id) {
        restaurantOrdersRepository.deleteById(id);

    }
    public List<RestaurantOrders> getTableOrders(RestaurantOrders orders){
        List<RestaurantOrders> allOrders = (List<RestaurantOrders>) restaurantOrdersRepository.findAll();
        List<RestaurantOrders> tableOrders = new ArrayList<>();
        for(RestaurantOrders order : allOrders){
            if(order.getTableNumber() == orders.getTableNumber()){
                tableOrders.add(order);
            }
        }
        return tableOrders;

    }
}
