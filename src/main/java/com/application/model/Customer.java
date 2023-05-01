package com.application.model;

import com.application.repositories.AccountRepositoryImpl;
import com.application.repositories.CustomerRepositoryImpl;

import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    int customerId;
    PaymentMethod paymentMethod;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String address;
    boolean isGuest;

    public Customer(PaymentMethod paymentMethod, String firstName, String lastName, String phoneNumber, String email, String address, boolean isGuest) {
        this.customerId = nextId();
        this.paymentMethod = paymentMethod;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.isGuest = isGuest;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", paymentMethod=" + paymentMethod +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", isGuest=" + isGuest +
                '}';
    }

    public Customer() {
    }

    public static int nextId(){
        int nextId = 0;
        ArrayList<Integer> accountID = new ArrayList<Integer>();

        for (int i = 0; i < CustomerRepositoryImpl.customers.size(); i++) {
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
