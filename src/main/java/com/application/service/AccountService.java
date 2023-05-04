package com.application.service;

import com.application.model.Account;
import com.application.model.PaymentMethod;

import java.util.Optional;

public interface AccountService {
    Iterable<Account> findAll();
    Optional<Account> findById(long id);
    Account save(Account account);
    void deleteById( long id);
}
