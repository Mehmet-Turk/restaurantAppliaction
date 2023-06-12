package com.application.repositories;

import com.application.model.RestaurantTables;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTablesRepository extends CrudRepository<RestaurantTables, Long> {


}
