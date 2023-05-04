package com.application.service;

import com.application.model.Customer;
import com.application.model.Table;
import com.application.repositories.CustomerRepository;
import com.application.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableServiceImpl implements TableService{
    @Autowired
    TableRepository tableRepository;
    @Override
    public Iterable<Table> findAll() {
        return tableRepository.findAll();
    }

    @Override
    public Optional<Table> findById(long id) {
        return tableRepository.findById(id);
    }

    @Override
    public Table save(Table table) {
        return tableRepository.save(table);
    }



    @Override
    public void deleteById(long id) {
        tableRepository.deleteById(id);

    }
}
