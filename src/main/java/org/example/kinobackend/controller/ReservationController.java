package org.example.kinobackend.controller;

import org.example.kinobackend.model.Reservation;
import org.example.kinobackend.model.Show;
import org.example.kinobackend.service.ReservationService;
import org.example.kinobackend.service.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    public final ReservationService reservationService;
    public final ShowService showService;

    public ReservationController(ReservationService reservationService, ShowService showService) {
        this.reservationService = reservationService;
        this.showService = showService;
    }

    @GetMapping("/{showId}")
    public ResponseEntity<Map<String, Object>> getReservations(@PathVariable int showId) {
        Optional<Reservation> reservations = reservationService.getReservations(showId);
        Optional<Show> getSeats = showService.getShow(showId);


        Map<String, Object> response = new HashMap<>();
        response.put("showId", showId);
        response.put("reservations", reservations);
        response.put("reservedSeats", getSeats);

        return ResponseEntity.ok(response);
    }


}
