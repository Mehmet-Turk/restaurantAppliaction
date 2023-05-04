package com.application.service;

import com.application.model.Customer;
import com.application.model.Table;

import java.util.Optional;

public interface TableService {
    Iterable<Table> findAll();
    Optional<Table> findById(long id);
    Table save(Table table);
    void deleteById( long id);
}
