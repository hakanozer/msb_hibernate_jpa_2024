package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public Customer customerAdd(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findGsm(String gsm) {
        Optional<Customer> optionalCustomer = customerRepository.findByAddresses_Phones_GsmEqualsIgnoreCase(gsm);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        return null;
    }

}
