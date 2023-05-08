package com.application;

import com.application.model.*;
import com.application.repositories.*;
import com.application.util.FakerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	PaymentMethodRepository paymentMethodRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	RestaurantTablesRepository restaurantTablesRepository;
	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
//		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		SpringApplication.run(DemoApplication.class, args);

//		for(String beanDefinitionName: applicationContext.getBeanDefinitionNames()){
//			System.out.println(beanDefinitionName);
//			if(beanDefinitionName.startsWith("paymentMethod")) {
//				Object object = applicationContext.getBean(beanDefinitionName);
//				System.out.println("Stop here");
//			}
//		}

	}

	@Override
	public void run(String... args) throws Exception {
		PaymentMethod paymentMethod;
		paymentMethod = new PaymentMethod("oylesine");
		paymentMethodRepository.save(paymentMethod);
		Customer customer;
		customer = new Customer(paymentMethod, "Ali", "Veli", "0329392", "dadafaf", "fasfa", false);
		customerRepository.save(customer);
		RestaurantTables table;
		table = new RestaurantTables(100, 3, false, true);
		restaurantTablesRepository.save(table);
		Reservation reservation;
		reservation = new Reservation(customer, table, LocalDate.of(22,2,2), LocalTime.MIDNIGHT,false );
		reservationRepository.save(reservation);
		Account account;
		account = new Account("John", "De Witt", FakerUtil.getFakePhoneNUmber(), FakerUtil.getFakeEmailAddress("John", "De Wit t"),FakerUtil.getFakePassword(),"General Manager");
		accountRepository.save(account);

	}
}
