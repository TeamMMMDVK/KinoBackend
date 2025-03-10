package org.example.kinobackend.repository;

import org.example.kinobackend.model.BookedSeat;
import org.example.kinobackend.model.BookedSeatID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookedSeatRepository extends JpaRepository<BookedSeat, BookedSeatID> {

    //Metodesignatur til at finde alle sæder på en bestemt forestilling
    List<BookedSeat> findByShow_ShowID(int showID);

}
