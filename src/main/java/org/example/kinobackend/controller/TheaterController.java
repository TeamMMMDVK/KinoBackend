package org.example.kinobackend.controller;
import java.util.List;
import org.example.kinobackend.model.Seat;
import org.example.kinobackend.service.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/theater")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/{theaterId}/seats")
    public ResponseEntity<List<Seat>> getSeatsByTheaterId(@PathVariable int theaterId) {
        List<Seat> seats = theaterService.getSeatsByTheaterId(theaterId);
        return ResponseEntity.ok(seats);

    }


}
