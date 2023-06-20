package com.application;

import com.application.model.*;
import com.application.model.MenuItem;
import com.application.repositories.*;
//import com.application.repositories.ReservationRepository;
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
	List<MenuItem> loadedItems = new ArrayList<>();


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
		LoadMenuItems();
		PaymentMethod paymentMethod;
		paymentMethod = new PaymentMethod("oylesine");
		paymentMethodRepository.save(paymentMethod);
//		Customer customer;


//		MenuItem menu1 = new MenuItem("Chicken Menu","Fast-Food","A 100g serving of baked chicken breast contains 4 grams of fat and 31 grams of protein",13.00,false);
//		menuItemRepository.save(menu1);
//		MenuItem menu2 = new MenuItem("Doner","Fast-food","The meat is typically seasoned with fresh herbs and spices.",10.00,false);
//		menuItemRepository.save(menu2);
//		MenuItem menu3 = new MenuItem("Beef Burger", "Fast-Food", "Juicy beef patty with fresh vegetables and cheese", 12.50, false);
//		menuItemRepository.save(menu3);
//		MenuItem menu4 = new MenuItem("Vegetable Pizza", "Italian", "A delicious pizza topped with a variety of fresh vegetables", 15.00, true);
//		menuItemRepository.save(menu4);


		RestaurantOrders restaurantOrder1 = new RestaurantOrders("Hamburger", 2, LocalDate.now(), LocalTime.now(),12,  111);
		restaurantOrdersRepository.save(restaurantOrder1);


		RestaurantOrders restaurantOrder2 = new RestaurantOrders("Pizza", 1, LocalDate.now(), LocalTime.now(),15,  117);
		restaurantOrdersRepository.save(restaurantOrder2);
//		restaurantOrders.save(orders);



//		restaurantOrders orders = new RestaurantOrders(menu1,menu2);
//		customer = new Customer("Ali Sen", "123456789", "emrah@gmail.com", 129);
//		customerRepository.save(customer);

//		MenuItem menuItem1 = new MenuItem("Pasta", "Pasta", "pasta", 12, false);
//		MenuItem menuItem2 = new MenuItem("Pasta", "Pasta", "pasta", 12, false);
//		List<MenuItem> orders = new ArrayList<>();
//		orders.add(menuItem1);
//		orders.add(menuItem2);
//		menuItemRepository.save(menuItem1);
//		MenuItem menuItem2 = new MenuItem("Hamburger", "Hamburger", "Hamburger", 14, false);
//		menuItemRepository.save(menuItem2);
//		List<MenuItem> orders = new ArrayList<>();
//		orders.add(menuItem1);
//		orders.add(menuItem2);

//		restaurantOrders = new RestaurantOrders(customer, orders);
//		restaurantOrdersRepository.save(restaurantOrders);
//		restaurantOrdersRepository.save(restaurantOrders);


//		RestaurantTables table;
//		table = new RestaurantTables(100, 3, false, true);
//		restaurantTablesRepository.save(table);
//		table = new RestaurantTables(101, 6, true, true);
//		restaurantTablesRepository.save(table);
//		List<RestaurantTables> res1 = new ArrayList<>();
//		res1.add(loadedTables.get(0));
//		res1.add(loadedTables.get(2));
//		Reservation reservation;
//		reservation = new Reservation(customer, res1 , LocalDate.of(2023,2,2), LocalTime.MIDNIGHT,false );
//		reservationRepository.save(reservation);
//		Reservation reservation;
//		reservation = new Reservation(res1, LocalDate.now(), LocalTime.MIDNIGHT, false, "ALi", 4, "234423", "rer", "321");
//		reservationRepository.save(reservation);

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

	public void LoadMenuItems(){
		List<String[]> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/menuItems.csv"))) {
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
		MenuItem item;
		List<MenuItem> items = new ArrayList<>();
		for (String [] arr: data) {
//			String itemName;
//			String type;
//			String description;
//			double price;
//			boolean isAlcoholic;

			String itemName = arr[0].replaceAll(",$", "");
			String type = arr[1].replaceAll(",$", "");
			String ingredients = arr[2].replaceAll(",$", "");
			double price = Double.parseDouble(arr[3].replaceAll(",$", ""));
			boolean Alcoholic = Boolean.parseBoolean(arr[3].replaceAll(",$", ""));
			item = new MenuItem(itemName, type, ingredients, price, Alcoholic);
			menuItemRepository.save(item);
			items.add(item);
		}
		loadedItems = items;

	}

}
