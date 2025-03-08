package org.example.kinobackend.controller;

import org.example.kinobackend.service.RevenueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/revenue")
public class RevenueController {

    private final RevenueService revenueService;


    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @GetMapping("/movie/{movieID}")
    public ResponseEntity<Double> getRevenueForMovie(@PathVariable int movieID) {
        return ResponseEntity.ok(revenueService.getRevenueForMovie(movieID));
    }


}
