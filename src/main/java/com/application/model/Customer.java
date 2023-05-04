package com.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Collections;
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long customerId;
    PaymentMethod paymentMethod;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String address;
    boolean isGuest;

    public Customer(PaymentMethod paymentMethod, String firstName, String lastName, String phoneNumber, String email, String address, boolean isGuest) {
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

//    public static int nextId(){
//        int nextId = 0;
//        ArrayList<Integer> accountID = new ArrayList<Integer>();
//
//        for (int i = 0; i < CustomerRepositoryImpl.customers.size(); i++) {
//            accountID.add((int) AccountRepositoryImpl.accounts.get(i).getAccountId());
//
//            Collections.sort(accountID, Collections.reverseOrder());
//
//        }
//        if (accountID.size() == 0){
//            return 1;
//        }else {
//            nextId = accountID.get(0) + 1;
//            return nextId;
//        }
//
//    }

}
