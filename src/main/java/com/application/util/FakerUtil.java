package com.application.util;

import com.github.javafaker.Faker;

import java.text.Format;
import java.util.Locale;

public class FakerUtil {

    private static Faker faker = new Faker();

    public static String getFakeEmailAddress(){
        //String email = fakeValuesService.bothify("????##@gmail.com");

        String email = faker.name().firstName() +
                "." +
                faker.name().lastName() +
                "@capgemini.com";

        return email.toLowerCase();

    }
    public static String getFakeEmailAddress(String firstName, String lastName){
        //String email = fakeValuesService.bothify("????##@gmail.com");

        String email = firstName +
                "." +
                lastName.replaceAll("\\s", "") +
                "@capgemini.com";

        return email.toLowerCase();

    }
    public static String getFakePhoneNUmber(){
        return  faker.numerify("06########");
    }
    public static String getFakeAddress(){
        Faker nlFaker = new Faker(new Locale("nl-NL"));
        return nlFaker.address().fullAddress();

        //return faker.address().fullAddress().formatted();
    }
    public static String getFakeFirstName(){
        return faker.name().firstName();
    }
    public static String getFakeLastName(){
        return faker.name().lastName();
    }

    public static String getFakePassword(){
        return faker.internet().password(8, 12);
    }
}
