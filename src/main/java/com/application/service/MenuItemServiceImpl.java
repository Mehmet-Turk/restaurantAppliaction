package com.application.service;

import com.application.model.Account;
import com.application.model.MenuItem;
import com.application.repositories.AccountRepository;
import com.application.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuItemServiceImpl implements MenuItemService{
    @Autowired
    MenuItemRepository menuItemRepository;

    @Override
    public Iterable<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    @Override
    public Optional<MenuItem> findById(long id) {
        return menuItemRepository.findById(id);
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public void deleteById(long id) {
        menuItemRepository.deleteById(id);

    }
}
