package com.application.controller;

import com.application.model.Reservation;
import com.application.model.RestaurantTables;
import com.application.service.ReservationService;
import com.application.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    ReservationService reservationService;



    // Endpoint
    // http://localhost:8080/api/reservation
    // POST
    @PostMapping(value = "/reservation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        // Gelen JSON verisinden table bilgisini alıp rezervasyon nesnesine ekleyebilirsiniz
//        List<RestaurantTables> table = reservation.getTable(); // Gelen table bilgisini alın
//        reservation.setTable(table); // Rezervasyon nesnesine table bilgisini ekleyin
        return ResponseEntity.ok().body(reservationService.save(reservation));

    }

    // Endpoint
    // http://localhost:8080/api/reservation
    // GET
    @GetMapping(value = "reservation", produces = "application/json")
    public Iterable<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    // Endpoint
    // http://localhost:8080/api/reservation/filter/true
    // GET
//    @PostMapping(value = "reservation/filter", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Iterable<Reservation>> getAllReservationsOnDate(@RequestBody Reservation reservation) {
//        return ResponseEntity.ok().body(
//                reservationService.filterReservationForBabyChair(reservation));
//    }

    // Endpoint
    // http://localhost:8080/api/reservation/2
    // GET
    @GetMapping(value = "reservation/{id}", produces = "application/json")
    public ResponseEntity<Reservation> getReservationById(@PathVariable long id) {
        Optional<Reservation> reservation = reservationService.findById(id);
        return reservation.isPresent() ? ResponseEntity.ok().body(reservation.get()) : ResponseEntity.notFound().build();
//        if(reservation.isPresent()){
//            return ResponseEntity.ok().body(reservation.get());
//        }
//        return ResponseEntity.notFound().build();

    }

    // Endpoint
    // http://localhost:8080/api/reservation/2
    // DEL
    @DeleteMapping("reservation/{id}")
    public ResponseEntity<Void> deleteReservationById(@PathVariable long id) {

        reservationService.remove(id);
        return ResponseEntity.ok().build();
    }

}
