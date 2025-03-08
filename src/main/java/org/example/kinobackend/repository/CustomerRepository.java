package org.example.kinobackend.repository;

import org.example.kinobackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    Optional<Customer> findByEmail(String customerEmail);
}
