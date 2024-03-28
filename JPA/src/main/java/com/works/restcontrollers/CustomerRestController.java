package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerRestController {

    final CustomerService customerService;

    @PostMapping("customerAdd")
    public Customer customerAdd(@RequestBody Customer customer) {
        return customerService.customerAdd(customer);
    }

    @GetMapping("gmsSearch")
    public Customer gmsSearch(@RequestParam String gsm) {
        return customerService.findGsm(gsm);
    }

}
