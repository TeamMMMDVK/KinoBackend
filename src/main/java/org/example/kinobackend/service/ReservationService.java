package org.example.kinobackend.service;

import jakarta.transaction.Transactional;
import org.example.kinobackend.dto.ProcessedReservationDTO;
import org.example.kinobackend.model.*;
import org.example.kinobackend.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final TicketService ticketService;


    public ReservationService(ReservationRepository reservationRepository, TicketService ticketService) {
        this.reservationRepository = reservationRepository;
        this.ticketService = ticketService;
    }

    //Vi får input fra POST Endpoint, som bruges til at opdatere db, og vi returnerer en reservationsoplysningerne i en DTO
    @Transactional
    public Reservation createReservation(Customer customer, double totalPrice) {
        Reservation reservation = new Reservation();
        reservation.setReservedAt(LocalDateTime.now());
        reservation.setCustomer(customer);
        reservation.setTotalPrice(totalPrice);
        Reservation savedReservation = reservationRepository.save(reservation); //get new reservation with id
        return savedReservation;
    }

    public double getTotalPrice(List<Integer> ticketTypeIDs){
        double totalPrice = 0.0;
        for(Integer ticketTypeID : ticketTypeIDs){
            totalPrice += ticketService.findTicketByID(ticketTypeID).getPrice();
        }
        return totalPrice;
    }

    public ProcessedReservationDTO mapReservationToConfirmedReservationDTO(Reservation reservation) {
        return new ProcessedReservationDTO(reservation.getReservationID(),
                reservation.getCustomer().getEmail(), reservation.getTotalPrice());
    }
}
