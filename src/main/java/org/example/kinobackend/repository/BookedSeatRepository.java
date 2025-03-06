package org.example.kinobackend.repository;

import org.example.kinobackend.model.BookedSeat;
import org.example.kinobackend.model.BookedSeatID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookedSeatRepository extends JpaRepository<BookedSeat, BookedSeatID> {

    //Metodesignatur til at finde alle sæder på en bestemt forestilling
    List<BookedSeat> findByShow_ShowID(int showID);

}
