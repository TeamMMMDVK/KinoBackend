package org.example.kinobackend.service;

import org.example.kinobackend.repository.BookedSeatRepository;
import org.springframework.stereotype.Service;

@Service
public class BookedSeatService {

    private BookedSeatRepository bookedSeatRepository;

    public BookedSeatService(BookedSeatRepository bookedSeatRepository) {
        this.bookedSeatRepository = bookedSeatRepository;
    }
}
