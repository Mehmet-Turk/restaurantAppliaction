package com.application.mvc;

import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller
public class Controller {
    // http://localhost:8080/
    @GetMapping("/")
    public String homePage() {

        System.out.println("Inside homePage");

        return "main";
    }
    // http://localhost:8080/stock
    @GetMapping("/stock")
    public String stockPage() {

        System.out.println("Inside stockPage");

        return "stock";
    }
    // http://localhost:8080/contact
    @GetMapping("/contact")
    public String contactPage() {

        System.out.println("Inside contactPage");

        return "contact";
    }

    // http://localhost:8080/stocks
    @GetMapping("/stocks")
    public String stocksPage() {

        System.out.println("Inside stockPage");

        return "stocks";
    }


    // http://localhost:8080/menu
    @GetMapping("/menu")
    public String menuPage() {

        System.out.println("Inside tablePage");

        // use customer for normal use
        // use customerT for 'template' use (header, menu, footer, etc.)
        return "menu";
    }
    // http://localhost:8080/about
    @GetMapping("/about")
    public String aboutPage() {

        System.out.println("Inside aboutPage");

        return "about";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/table")
    public String customerPage(){
        return "table";
    }
    @GetMapping("/reservation")
    public String reservationPage(){
        return "reservation";
    }
    // http://localhost:8080/reservations
    @GetMapping("/reservations")
    public String reservationsPage(){
        return "reservations";
    }

    // http://localhost:8080/orders
    @GetMapping("/orders")
    public String ordersPage(){
        return "orders";
    }



    // http://localhost:8080/checkout
    @GetMapping("/checkout")
    public String checkoutPage(){
        return "checkout";
    }

    // http://localhost:8080/forgot
    @GetMapping("/forgot")
    public String forgotPage(){
        return "forgot";
    }

    @GetMapping("/reservationDetails")
    public String reservationDetailsPage(){
        return "reservationDetails";
    }
}
