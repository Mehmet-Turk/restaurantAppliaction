package com.application.repositories;

import com.application.model.Account;
import com.application.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository{
    public static List<Account> accounts = new ArrayList<>();


    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public Account findById(long id) {

        for( Account account: accounts){
            if( account.getAccountId() == id){
                return account;
            }
        }

        return null;
    }

    @Override
    public Account save(Account account) {

        accounts.add(account);

        return account;
    }

    @Override
    public void remove(long id) {
        accounts = accounts.
                stream().filter(account -> account.getAccountId()!=id).toList();
    }
}
