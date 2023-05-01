package com.application.repositories;

import com.application.model.Account;
import com.application.model.Reservation;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
    Account findById(long id);
    Account save(Account account);
    void remove( long id);
}
