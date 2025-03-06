package org.example.kinobackend.repository;

import org.example.kinobackend.model.BookedSeat;
import org.example.kinobackend.model.BookedSeatID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookedSeatRepository extends JpaRepository<BookedSeat, BookedSeatID> {
}
