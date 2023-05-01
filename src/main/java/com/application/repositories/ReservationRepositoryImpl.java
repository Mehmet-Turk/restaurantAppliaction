package com.application.repositories;

import com.application.model.Reservation;
import com.application.util.FakerUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationRepositoryImpl implements ReservationRepository {

    private List<Reservation> reservations = new ArrayList<>();

    public ReservationRepositoryImpl() {
        Reservation reservation;

        // id is set in constructor
        reservation = new Reservation( 3, "06-49274625", FakerUtil.getFakeEmailAddress(), 4, false, LocalDate.now());
        reservations.add(reservation);
        reservation = new Reservation( 6, "06-83645095", FakerUtil.getFakeEmailAddress(), 2, true, LocalDate.now());
        reservations.add(reservation);
        reservation = new Reservation( 2, "06-91029374", FakerUtil.getFakeEmailAddress(), 4, false, LocalDate.now());
        reservations.add(reservation);
        reservation = new Reservation( 7, "06-77293550", FakerUtil.getFakeEmailAddress(), 2, true, LocalDate.now());
        reservations.add(reservation);
        reservation = new Reservation( 5, "06-12398702", FakerUtil.getFakeEmailAddress(), 3, false, LocalDate.now());
        reservations.add(reservation);

    }

    @Override
    public List<Reservation> findAll(){
        return reservations;
    }

    @Override
    public Optional<Reservation> findById(long id){

        for( Reservation reservation: reservations){
            if( reservation.getId() == id){
                return Optional.of(reservation);
            }
        }

        return null;
    }

    @Override
    public Optional<Reservation> save(Reservation reservation){

        reservations.add(reservation);

        return Optional.ofNullable(reservation);
    }

    @Override
    public void remove( long id){

//        List<Reservation> newReservations = new ArrayList<>();

//        for( Reservation reservation: reservations){
//
//            if( reservation.getId() != id){
//                newReservations.add(reservation);
//            }
//        }

        reservations = reservations
                .stream()
                .filter( reservation -> reservation.getId()!=id )
                .toList();

//    (x) -> someFunction on x



    }
}
