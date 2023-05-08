package com.application.controller;

import com.application.model.Account;
import com.application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountService accountService;
    // Endpoint
    // http://localhost:8080/api/account
    // POST
    @PostMapping(value = "account", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){

        return ResponseEntity.ok().body(accountService.save(account));

    }

    // Endpoint
    // http://localhost:8080/api/account
    // GET
    @GetMapping(value = "account", produces = "application/json")
    public Iterable<Account> getAllAccount(){

        return accountService.findAll();
    }

    // Endpoint
    // http://localhost:8080/api/account
    // GET
    @GetMapping(value = "account/{id}", produces = "application/json")
    public ResponseEntity<Account> getAccountById(@PathVariable long id){
        Optional<Account> account = accountService.findById(id);
        return account.isPresent()? ResponseEntity.ok().body(account.get()):ResponseEntity.notFound().build();

    }
    // Endpoint
    // http://localhost:8080/api/account/2
    // DEL
    @DeleteMapping("account/{id}")
    public ResponseEntity<Void> deleteAccountId( @PathVariable long id){

        accountService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
