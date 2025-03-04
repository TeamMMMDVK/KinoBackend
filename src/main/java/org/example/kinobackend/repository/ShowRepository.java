package org.example.kinobackend.repository;

import org.example.kinobackend.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
