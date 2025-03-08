package org.example.kinobackend.service;

import jakarta.transaction.Transactional;
import org.example.kinobackend.dto.BookedSeatDTO;
import org.example.kinobackend.dto.ReservationDTO;
import org.example.kinobackend.model.*;
import org.example.kinobackend.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private final BookedSeatRepository bookedSeatRepository;
    private final TicketRepository ticketRepository;


    public ReservationService(TicketRepository ticketRepository, ReservationRepository reservationRepository, CustomerRepository customerRepository, ShowRepository showRepository, SeatRepository seatRepository, BookedSeatRepository bookedSeatRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.bookedSeatRepository = bookedSeatRepository;
        this.ticketRepository = ticketRepository;

    }

    //Vi får input fra POST Endpoint, som bruges til at opdatere db, og vi returnerer en reservationsoplysningerne i en DTO
    @Transactional
    public ReservationDTO createReservation(String customerName, String customerEmail, int showID, List<Integer> seatIds, List<Integer> ticketIds) {
        // Vi finder eller opretter customer
        Customer customer = customerRepository.findByEmail(customerEmail)
                .orElseGet(() -> {
                    Customer newCustomer = new Customer();
                    newCustomer.setFullName(customerName);
                    newCustomer.setEmail(customerEmail);
                    return customerRepository.save(newCustomer);
                });

        // Opretter reservation
        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setReserved_at(LocalDateTime.now());

        // Gem reservation for at få ID
        reservation = reservationRepository.save(reservation);

        double totalPrice = 0.0;
        List<BookedSeatDTO> bookedSeatDTOs = new ArrayList<>();

        // Vi opretter og gemmer BookedSeat-poster og til dette skal vi have hele objekter af show, seat og ticket
        //Vi konverterer også og gemmer i DTO til returnering
        for (int i = 0; i < seatIds.size(); i++) {
            Seat seat = seatRepository.findById(seatIds.get(i))
            .orElseThrow(() -> new RuntimeException("Seat not found"));
            Show show = showRepository.findById(showID)
                    .orElseThrow(() -> new RuntimeException("Show not found"));
            Ticket ticket = ticketRepository.findById(ticketIds.get(i))
                    .orElseThrow(() -> new RuntimeException("Ticket not found"));

            BookedSeat bookedSeat = new BookedSeat();
            bookedSeat.setSeat(seat);
            bookedSeat.setShow(show);
            bookedSeat.setTicket(ticket);
            bookedSeat.setReservation(reservation);
            bookedSeatRepository.save(bookedSeat);//Her gemmer vi i DB

            // Tilføj til DTO-liste
            bookedSeatDTOs.add(new BookedSeatDTO(seat.getSeatID(),
                    seat.getSeatRow(), seat.getSeatNumber(), show.getTheater().getTheaterName(),show.getMovie().getTitle(),
                    reservation.getReservationID(),ticket.getTicketID(),show.getStartTime(), ticket.getTicketType(), ticket.getPrice()));
            totalPrice += ticket.getPrice();
        }

        // Opdater totalpris i reservationen og gem i db
        reservation.setTotalPrice(totalPrice);
        reservationRepository.save(reservation);

        // Returnér ReservationDTO som også indeholder liste med BookedSeatDTO
        return new ReservationDTO(
                reservation.getReservationID(),
                customer.getFullName(),
                customer.getEmail(),
                reservation.getReserved_at(),
                totalPrice,
                bookedSeatDTOs);
    }

}
