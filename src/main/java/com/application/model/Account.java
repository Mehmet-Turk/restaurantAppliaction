package com.application.model;

import com.application.repositories.AccountRepositoryImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    int accountId;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String password;
    String role;

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public Account() {
    }

    public Account(String firstName, String lastName, String phoneNumber, String email, String password, String role) {
        this.accountId = nextId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static int nextId(){
        int nextId = 0;
        ArrayList<Integer> accountID = new ArrayList<Integer>();

        for (int i = 0; i < AccountRepositoryImpl.accounts.size(); i++) {
            accountID.add(AccountRepositoryImpl.accounts.get(i).getAccountId());

            Collections.sort(accountID, Collections.reverseOrder());

        }
        if (accountID.size() == 0){
            return 1;
        }else {
            nextId = accountID.get(0) + 1;
            return nextId;
        }

    }

}

