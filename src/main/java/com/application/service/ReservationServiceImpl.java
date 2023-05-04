package com.application.service;

import com.application.model.Reservation;
import com.application.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository ;

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

        return reservationRepository.save(reservation);
    }

    @Override
    public void remove(long id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public Iterable<Reservation> filterReservationForBabyChair(Reservation reservation) {

        List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();

//        String s1 = "Hello";
//        String s2 = null;
//        boolean check = s2 == null? true: s1.equals(s2);

        return reservations.stream()
                .filter( x -> x.isAddBabyChair() == reservation.isAddBabyChair())
                .filter( x -> x.getCustomer() == reservation.getCustomer())
//                .filter( x -> x.isVegan())
                .toList();

    }
}
