package com.application.service;

import com.application.model.MenuItem;

import java.util.Optional;

public interface MenuItemService {
    Iterable<MenuItem> findAll();
    Optional<MenuItem> findById(long id);
    MenuItem save(MenuItem menuItem);
    void deleteById( long id);
}
