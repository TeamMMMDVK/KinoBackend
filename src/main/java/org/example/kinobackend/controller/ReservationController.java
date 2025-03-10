package org.example.kinobackend.controller;

import org.example.kinobackend.dto.ProcessedReservationDTO;
import org.example.kinobackend.dto.ReservationDTO;
import org.example.kinobackend.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    public final BookingService bookingService;

    public ReservationController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<ProcessedReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        ProcessedReservationDTO responseDTO = bookingService.processNewBooking(reservationDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
