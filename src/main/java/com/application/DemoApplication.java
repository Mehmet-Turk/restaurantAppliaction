package com.application;

import com.application.model.*;
import com.application.repositories.*;
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
	@Autowired
	MenuItemRepository menuItemRepository;
	@Autowired
	RestaurantOrdersRepository restaurantOrdersRepository;
	@Autowired
	StockRepository stockRepository;
	List<RestaurantTables> loadedTables = new ArrayList<>();

	List<Stock> loadedStocks = new ArrayList<>();


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
		LoadStocks();
		PaymentMethod paymentMethod;
		paymentMethod = new PaymentMethod("oylesine");
		paymentMethodRepository.save(paymentMethod);
		Customer customer;
		customer = new Customer(paymentMethod, "Ali", "Veli", "0329392212", "dadafaf", "fasfa", false);
		customerRepository.save(customer);

		MenuItem menuItem1 = new MenuItem("Pasta", "Pasta", "pasta", 12, false);
		menuItemRepository.save(menuItem1);
		MenuItem menuItem2 = new MenuItem("Hamburger", "Hamburger", "Hamburger", 14, false);
		menuItemRepository.save(menuItem2);
		List<MenuItem> orders = new ArrayList<>();
		orders.add(menuItem1);
		orders.add(menuItem2);
		RestaurantOrders restaurantOrders;
		restaurantOrders = new RestaurantOrders(customer, orders);
		restaurantOrdersRepository.save(restaurantOrders);
//		RestaurantTables table;
//		table = new RestaurantTables(100, 3, false, true);
//		restaurantTablesRepository.save(table);
//		table = new RestaurantTables(101, 6, true, true);
//		restaurantTablesRepository.save(table);
		List<RestaurantTables> res1 = new ArrayList<>();
		res1.add(loadedTables.get(0));
		res1.add(loadedTables.get(2));
		Reservation reservation;
		reservation = new Reservation(customer, res1 , LocalDate.of(2023,2,2), LocalTime.MIDNIGHT,false );
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

	public void LoadStocks(){
		List<String[]> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/StockEngCSVShort.csv"))) {
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
		Stock stock;
		List<Stock> stocks = new ArrayList<>();
		for (String [] arr: data) {

			String name = arr[0].replaceAll(",$", "");
			int recentAmount = Integer.parseInt(arr[1].replaceAll(",$", ""));
			int minAmount = Integer.parseInt(arr[2].replaceAll(",$", ""));

			stock = new Stock(name, recentAmount, minAmount);
			stockRepository.save(stock);
			stocks.add(stock);
		}
		loadedStocks = stocks;

	}

}
