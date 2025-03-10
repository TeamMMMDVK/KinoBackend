package org.example.kinobackend.controller;
import java.util.List;

import org.example.kinobackend.dto.SeatDTO;
import org.example.kinobackend.model.Seat;
import org.example.kinobackend.service.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/theater")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/{theaterId}/seats")
    public ResponseEntity<List<SeatDTO>> getSeatsByTheaterId(@PathVariable int theaterId) {
        List<SeatDTO> seats = theaterService.getSeatsByTheaterId(theaterId);
        return ResponseEntity.ok(seats);

    }


}
