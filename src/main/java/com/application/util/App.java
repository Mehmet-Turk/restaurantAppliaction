package com.application.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        write();
//        Account account = new Account("Ali", "Veli", "0674238232", "sadda", "dad", "manager");
//        AccountRepositoryImpl.accounts.add(account);
//        Account account1 = new Account("John", "Huis", "06274383122", "ssafwqr", "afrwrhr", "role");
//        AccountRepositoryImpl.accounts.add(account1);
//        System.out.println(AccountRepositoryImpl.accounts);
//        AccountRepositoryImpl.accounts.remove(0);
//        Account account2 = new Account("John", "Huis", "06274383122", "ssafwqr", "afrwrhr", "role");
//        AccountRepositoryImpl.accounts.add(account2);
        System.out.println(FakerUtil.getFakeLastName());


    }
    public static void write(){
        File file = new File("src/main/resources/data2.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter br = new BufferedWriter(fr);
        try {
            br.write("\nINSERT INTO menuItem (menuItemId, itemName, type, description, price, isAlcoholic, imagePath)\n" +
                    "VALUES (1, 'Hamburger', 'Hamburger Mushroom', 'Mushroom, cheddar, and meat', 15.99, false, '/images/Mushroom.jpg');");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
