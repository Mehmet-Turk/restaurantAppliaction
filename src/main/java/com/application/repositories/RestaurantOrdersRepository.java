package com.application.repositories;

import com.application.model.RestaurantOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantOrdersRepository extends CrudRepository<RestaurantOrders, Long> {
}
