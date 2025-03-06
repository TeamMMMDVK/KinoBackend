package org.example.kinobackend.controller;

import org.example.kinobackend.dto.SeatBlockUpdateDTO;
import org.example.kinobackend.model.Seat;
import org.example.kinobackend.repository.SeatRepository;
import org.example.kinobackend.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seat")
public class SeatController {

    private final SeatService seatService;
    private final SeatRepository seatRepository;

    public SeatController(SeatService seatService, SeatRepository seatRepository) {
        this.seatService = seatService;
        this.seatRepository = seatRepository;
    }

    @GetMapping("/{seatId}") //Henter specifik sæde i en sal...ved ikke om denne skal bruges som Endpoint?
    public ResponseEntity<Seat> getSeatById(@PathVariable int seatId) {
        Seat requestedSeat = seatService.getSeatById(seatId);
        return ResponseEntity.ok(requestedSeat);
    }

    @PutMapping("/{seatId}")
    public ResponseEntity<Seat> updateSeatBlockedStatus(@PathVariable int seatId, @RequestBody SeatBlockUpdateDTO seatBlockUpdateDTO) {
        Seat seatToBeChanged = seatService.getSeatById(seatId);//Henter korrekt sæde i salen
        seatToBeChanged.setBlocked(seatBlockUpdateDTO.isBlocked()); //ændrer attribut
        Seat updatedSeat = seatService.updateSeat(seatToBeChanged); //gemmer ændringer i db
        return ResponseEntity.ok(updatedSeat);
    }
}
