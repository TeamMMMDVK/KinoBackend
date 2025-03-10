package org.example.kinobackend.service;

import org.example.kinobackend.dto.ProcessedReservationDTO;
import org.example.kinobackend.dto.ReservationDTO;
import org.example.kinobackend.exceptions.ErrorCreatingReservationException;
import org.example.kinobackend.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {


    private final ReservationService reservationService;
    private final BookedSeatService bookedSeatService;
    private final CustomerService customerService;

    public BookingService(ReservationService reservationService, BookedSeatService bookedSeatService, CustomerService customerService) {
        this.reservationService = reservationService;
        this.bookedSeatService = bookedSeatService;
        this.customerService = customerService;
    }


    public ProcessedReservationDTO processNewBooking(ReservationDTO reservationDTO) {

        double totalPrice = reservationService.getTotalPrice(reservationDTO.getTicketIDs());
        Customer customer = customerService.createCustomerFromNewReservation(reservationDTO);
        Reservation newReservation = reservationService.createReservation(customer, totalPrice);
        List<BookedSeat> bookedSeats = bookedSeatService.createBookedSeats(reservationDTO.getSeatsIDs(),
                reservationDTO.getShowID(), reservationDTO.getTicketIDs(), newReservation);

        ProcessedReservationDTO responseDTO = reservationService.mapReservationToConfirmedReservationDTO(newReservation);
        responseDTO.setBookedSeats(bookedSeats.stream()
                .map(bs -> bookedSeatService.mapBookedSeatToBookedSeatDTO(bs))
                .collect(Collectors.toList()));


        if (responseDTO.getReservationID() != 0) return responseDTO;
        else throw new ErrorCreatingReservationException("Could not create new reservation of the seats.");
    }

}
