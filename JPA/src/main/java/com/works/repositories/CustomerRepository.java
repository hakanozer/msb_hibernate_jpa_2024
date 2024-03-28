package com.works.repositories;

import com.works.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByAddresses_CityContainsIgnoreCase(String city);

    Optional<Customer> findByAddresses_Phones_GsmEqualsIgnoreCase(String gsm);



}