package org.example.kinobackend.repository;

import org.example.kinobackend.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
