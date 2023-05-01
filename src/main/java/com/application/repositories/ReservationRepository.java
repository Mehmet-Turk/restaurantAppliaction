package com.application.repositories;

import com.application.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    Iterable<Reservation> findAll();
    Optional<Reservation> findById(long id);
    Optional<Reservation> save(Reservation reservation);
    void remove( long id);
}
