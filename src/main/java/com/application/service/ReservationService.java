package com.application.service;

import com.application.model.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Iterable<Reservation> findAll();
    Optional<Reservation> findById(long id);
    Optional<Reservation> save(Reservation reservation);
    void remove( long id);
    List<Reservation> filterReservationForVegan(Reservation reservation);
}
