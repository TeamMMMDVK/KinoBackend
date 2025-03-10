package org.example.kinobackend.controller;

import org.example.kinobackend.service.RevenueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
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
