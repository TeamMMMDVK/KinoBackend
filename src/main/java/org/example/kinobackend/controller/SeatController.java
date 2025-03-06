package org.example.kinobackend.controller;

import org.example.kinobackend.model.Seat;
import org.example.kinobackend.repository.SeatRepository;
import org.example.kinobackend.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/seat")
public class SeatController {

    private final SeatService seatService;
    private final SeatRepository seatRepository;

    public SeatController(SeatService seatService, SeatRepository seatRepository) {
        this.seatService = seatService;
        this.seatRepository = seatRepository;
    }

    @GetMapping("/{seatId}")
    public ResponseEntity<Seat> getSeatById(@PathVariable int seatId) {
        Seat requestedSeat = seatService.getSeatById(seatId);
        return ResponseEntity.ok(requestedSeat);
    }
}
