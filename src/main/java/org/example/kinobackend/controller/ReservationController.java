package org.example.kinobackend.controller;

import org.example.kinobackend.dto.ReservationDTO;
import org.example.kinobackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    public final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody Map<String, Object> request) {
        /*
        Map<String, Object> request: Denne Map vil være fyldt med de data, der sendes i JSON-body'en.
        Key i Map-en vil være de samme som de JSON-felter, der sendes fra frontend. Herefter skal de
        de indlæste værdier fra mappen typecastes til de respektive typer, som vi har brug for (f.eks.
        String for customerName og int for showID).
         */
        String customerName = (String)request.get("customerName");
        String customerEmail = (String)request.get("customerEmail");
        int showID = (int)request.get("showID");
        List<Integer> seatIDs = (List<Integer>) request.get("seatIDs");
        List<Integer> ticketIDs = (List<Integer>) request.get("ticketIDs");

        ReservationDTO reservationDTO = reservationService.createReservation(
                customerName,
                customerEmail,
                showID,
                seatIDs,
                ticketIDs
        );
        return ResponseEntity.ok(reservationDTO);
    }
}
