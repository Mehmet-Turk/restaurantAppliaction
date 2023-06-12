package com.application.service;

import com.application.model.Reservation;
import com.application.model.RestaurantTables;
import com.application.repositories.ReservationRepository;
import com.application.repositories.RestaurantTablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository ;
    @Autowired
    RestaurantTablesRepository restaurantTablesRepository;

    @Override
    public List<Reservation> findAll() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation save(Reservation reservation) {
        List <RestaurantTables> tables = (List<RestaurantTables>) restaurantTablesRepository.findAll();
//
        Collections.sort(tables, new Comparator<RestaurantTables>() {
            @Override
            public int compare(RestaurantTables table1, RestaurantTables table2) {
                return table2.getSeat() - table1.getSeat();
            }
        });

        for (RestaurantTables table: tables) {
            System.out.println(table.getSeat());

        }
        List <RestaurantTables> reservedTables = new ArrayList<>();
        int numberOfPeople = reservation.getNumberOfPeople();
        int count = 0;
        int i = 0;
        while (numberOfPeople>= tables.get(i).getSeat()){
            reservedTables.add(tables.get(i));
            numberOfPeople -= tables.get(i).getSeat();
            tables.remove(i);
            i++;
            if(i> tables.size()){
                break;
            }
        }
        Collections.sort(tables, new Comparator<RestaurantTables>() {
            @Override
            public int compare(RestaurantTables table1, RestaurantTables table2) {
                return table1.getSeat() - table2.getSeat();
            }
        });

        for (RestaurantTables table:tables ) {

            if(numberOfPeople >= count){
                reservedTables.add(table);
                count += table.getSeat();
            }else{
            break;
            }

        }
        reservation.setTable(reservedTables);
        
        //all reservations
        // get available tables
        // Choose tables 8  4 + 4 5 + 3




        return reservationRepository.save(reservation);
    }

    @Override
    public void remove(long id) {
        reservationRepository.deleteById(id);

    }

//    @Override
//    public Iterable<Reservation> filterReservationForBabyChair(Reservation reservation) {
//
//        List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();
//
////        String s1 = "Hello";
////        String s2 = null;
////        boolean check = s2 == null? true: s1.equals(s2);
//
//        return reservations.stream()
//                .filter( x -> x.isAddBabyChair() == reservation.isAddBabyChair())
//                .filter( x -> x.getCustomer() == reservation.getCustomer())
////                .filter( x -> x.isVegan())
//                .toList();
//
//    }
}
