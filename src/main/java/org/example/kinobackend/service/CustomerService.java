package org.example.kinobackend.service;

import jakarta.transaction.Transactional;
import org.example.kinobackend.dto.ReservationDTO;
import org.example.kinobackend.model.Customer;
import org.example.kinobackend.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public synchronized Customer createCustomerFromNewReservation(ReservationDTO reservationDTO){
        // Vi finder eller opretter customer
        return customerRepository.findByEmail(reservationDTO.getCustomerEmail())
                .orElseGet(() -> {
                    Customer newCustomer = new Customer(reservationDTO.getCustomerName(),
                            reservationDTO.getCustomerEmail());
                    return customerRepository.save(newCustomer);
                });
    }
}
