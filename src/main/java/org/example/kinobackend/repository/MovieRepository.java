package org.example.kinobackend.repository;

import org.example.kinobackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {


}
