package org.example.kinobackend.controller;

import org.example.kinobackend.dto.BookedSeatDTO;
import org.example.kinobackend.service.BookedSeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookedseat")
public class BookedSeatController {

    private final BookedSeatService bookedSeatService;

    public BookedSeatController(BookedSeatService bookedSeatService) {
        this.bookedSeatService = bookedSeatService;
    }

    @GetMapping("/show/{showID}")
    public ResponseEntity<List<BookedSeatDTO>> getAllSeatsSpecificShowWithStatus(@PathVariable int showID) {
        List<BookedSeatDTO> seatsOverviewSpecificShow = bookedSeatService.getAllSeatsSpecificShowWithStatus(showID);
        return ResponseEntity.ok(seatsOverviewSpecificShow);
    }
}

