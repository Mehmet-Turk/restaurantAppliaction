package com.application.service;

import com.application.model.Reservation;
import com.application.repositories.ReservationRepository;
import com.application.repositories.ReservationRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {

    ReservationRepository reservationRepository = new ReservationRepositoryImpl();

    @Override
    public List<Reservation> findAll() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Optional<Reservation> save(Reservation reservation) {

        return reservationRepository.save(reservation);
    }

    @Override
    public void remove(long id) {
        reservationRepository.remove(id);

    }

    @Override
    public List<Reservation> filterReservationForVegan(Reservation reservation) {

        List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();

//        String s1 = "Hello";
//        String s2 = null;
//        boolean check = s2 == null? true: s1.equals(s2);

        List<Reservation> filtered = reservations.stream()
                .filter( x -> x.isVegan() == reservation.isVegan())
                .filter( x -> x.getGuests() == reservation.getGuests())
//                .filter( x -> x.isVegan())
                .toList();

        return filtered;
    }
}
