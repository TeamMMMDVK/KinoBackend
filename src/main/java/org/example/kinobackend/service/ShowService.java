package org.example.kinobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {
    public final ShowService showService;
    @Autowired
    public ShowService(ShowService showService) {
        this.showService = showService;
    }
}
