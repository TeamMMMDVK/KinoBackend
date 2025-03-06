package org.example.kinobackend.controller;

import org.example.kinobackend.service.BookedSeatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookedseat")
public class BookedSeatController {

    private final BookedSeatService bookedSeatService;

    public BookedSeatController(BookedSeatService bookedSeatService) {
        this.bookedSeatService = bookedSeatService;
    }
}

