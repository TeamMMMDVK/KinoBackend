package org.example.kinobackend.controller;

import org.example.kinobackend.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/show")
public class ShowController {
    private final ShowService showService;
    public ShowController(ShowService showService) {
        this.showService = showService;
    }
}
