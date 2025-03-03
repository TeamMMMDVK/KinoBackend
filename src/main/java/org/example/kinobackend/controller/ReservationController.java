package org.example.kinobackend.controller;

import org.example.kinobackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    public final ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
}
