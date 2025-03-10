package org.example.kinobackend.controller;

import org.example.kinobackend.dto.BookedSeatDTO;
import org.example.kinobackend.service.BookedSeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/bookedseat")
public class BookedSeatController {

    private final BookedSeatService bookedSeatService;

    public BookedSeatController(BookedSeatService bookedSeatService) {
        this.bookedSeatService = bookedSeatService;
    }

    @GetMapping("/show/{showID}")
    public ResponseEntity<List<BookedSeatDTO>> getAllBookedSeatsSpecificShow(@PathVariable int showID) {
        List<BookedSeatDTO> seatsOverviewSpecificShow = bookedSeatService.getAllBookedSeatsSpecificShow(showID);
        return ResponseEntity.ok(seatsOverviewSpecificShow);
    }
}

