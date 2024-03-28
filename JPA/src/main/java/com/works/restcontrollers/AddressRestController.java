package com.works.restcontrollers;

import com.works.entities.Address;
import com.works.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddressRestController {

    final AddressService addressService;

    @PostMapping("addAddress")
    public Address addAddress(@RequestBody Address address) {
        return addressService.addressSave(address);
    }

}
