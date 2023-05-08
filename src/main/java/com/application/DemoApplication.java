package com.application;

import com.application.model.Customer;
import com.application.model.PaymentMethod;
import com.application.model.Reservation;
import com.application.model.RestaurantTables;
import com.application.repositories.CustomerRepository;
import com.application.repositories.PaymentMethodRepository;
import com.application.repositories.ReservationRepository;
import com.application.repositories.RestaurantTablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
	List<RestaurantTables> loadedTables = new ArrayList<>();

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

		LoadTables();
		PaymentMethod paymentMethod;
		paymentMethod = new PaymentMethod("oylesine");
		paymentMethodRepository.save(paymentMethod);
		Customer customer;
		customer = new Customer(paymentMethod, "Ali", "Veli", "0329392212", "dadafaf", "fasfa", false);
		customerRepository.save(customer);
//		RestaurantTables table;
//		table = new RestaurantTables(100, 3, false, true);
//		restaurantTablesRepository.save(table);
//		table = new RestaurantTables(101, 6, true, true);
//		restaurantTablesRepository.save(table);
		Reservation reservation;
		reservation = new Reservation(customer, loadedTables.get(0), LocalDate.of(2023,2,2), LocalTime.MIDNIGHT,false );
		reservationRepository.save(reservation);

	}
	public void LoadTables(){
		List<String[]> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/restaurantTablesCsv.csv"))) {
			String line;
			int k=0;
			while ((line = br.readLine()) != null) {
				if (k==0){
					k++;
					continue;
				}
				String[] fields = line.split(",");
				data.add(fields);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		RestaurantTables table;
		List<RestaurantTables> tables = new ArrayList<>();
		for (String [] arr: data) {

			int tableNumber = Integer.parseInt(arr[0].replaceAll(",$", ""));
			int seat = Integer.parseInt(arr[1].replaceAll(",$", ""));
			boolean isMergeable = Boolean.parseBoolean(arr[2].replaceAll(",$", ""));
			boolean isAvailable = Boolean.parseBoolean(arr[3].replaceAll(",$", ""));
			table = new RestaurantTables(tableNumber, seat, isMergeable, isAvailable);
			restaurantTablesRepository.save(table);
			tables.add(table);
		}
		loadedTables = tables;

	}

}
