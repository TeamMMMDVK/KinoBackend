package org.example.kinobackend.repository;

import org.example.kinobackend.model.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
public class TicketRepositoryTest {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCountByBookedSeatShowMovieMovieID_ShouldReturnCorrectTicketCount() {
        Movie movie = new Movie("Test Movie");
        entityManager.persist(movie);

        Theater theater = new Theater("Main Theater");
        entityManager.persist(theater);

        Show show = new Show(movie, theater);
        entityManager.persist(show);

        Seat seat1 = new Seat(theater);
        entityManager.persist(seat1);

        BookedSeat bookedSeat1 = new BookedSeat(show, seat1, Status.BOOKED);
        entityManager.persist(bookedSeat1); 

        Ticket ticket1 = new Ticket(bookedSeat1);
        entityManager.persist(ticket1); 

        Seat seat2 = new Seat(theater);
        entityManager.persist(seat2);

        BookedSeat bookedSeat2 = new BookedSeat(show, seat2, Status.BOOKED);
        entityManager.persist(bookedSeat2); 
        
        Ticket ticket2 = new Ticket(bookedSeat2);
        entityManager.persist(ticket2);
        
        for (int i = 3; i <= 5; i++) {
            Seat newSeat = new Seat(theater);
            entityManager.persist(newSeat);

            BookedSeat newBookedSeat = new BookedSeat(show, newSeat, Status.BOOKED);
            entityManager.persist(newBookedSeat);  

            Ticket newTicket = new Ticket(newBookedSeat);
            entityManager.persist(newTicket);  
        }
        
        entityManager.flush();
        entityManager.clear();
        
        assertEquals(5, ticketRepository.countByBookedSeatShowMovieMovieID(movie.getMovieID()));
    }
}