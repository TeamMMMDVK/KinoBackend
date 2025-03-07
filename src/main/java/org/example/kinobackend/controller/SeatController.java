package org.example.kinobackend.controller;

import org.example.kinobackend.dto.SeatBlockUpdateDTO;
import org.example.kinobackend.dto.SeatDTO;
import org.example.kinobackend.model.Seat;
import org.example.kinobackend.repository.SeatRepository;
import org.example.kinobackend.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seat")
public class SeatController {

    private final SeatService seatService;
    private final SeatRepository seatRepository;

    public SeatController(SeatService seatService, SeatRepository seatRepository) {
        this.seatService = seatService;
        this.seatRepository = seatRepository;
    }

    //Skal hente et sæde til visning i FrontEnd, her anvendes DTO
    @GetMapping("/{seatId}") //Henter specifik sæde (dto) i en sal...ved ikke om denne skal bruges som Endpoint?
    public ResponseEntity<SeatDTO> getSeatById(@PathVariable int seatId) {
        SeatDTO requestedSeat = seatService.getSeatByIdDTO(seatId);
        return ResponseEntity.ok(requestedSeat);
    }

    //Her skal vi opdatere et sæde, derfor skal vi have fat i det rigtige sæde Entity til selve
    //opdateringen, men vi returnerer DTO i visningen
    @PutMapping("/{seatId}")
    public ResponseEntity<SeatDTO> updateSeatBlockedStatus(@PathVariable int seatId, @RequestBody SeatBlockUpdateDTO seatBlockUpdateDTO) {
        Seat seatToBeChanged = seatService.getSeatById(seatId);//Henter korrekt sæde i salen fra db
        seatToBeChanged.setBlocked(seatBlockUpdateDTO.isBlocked()); //ændrer attribut
        Seat updatedSeat = seatService.updateSeat(seatToBeChanged); //gemmer ændringer i db

        //Konverterer til DTO inden returnering tilbage og visning
        SeatDTO updatedSeatDTO = new SeatDTO(updatedSeat.getSeatID(),updatedSeat.getSeatRow(),updatedSeat.getSeatNumber(),updatedSeat.isBlocked(),updatedSeat.getTheater().getTheaterName());
        return ResponseEntity.ok(updatedSeatDTO);
    }
}
