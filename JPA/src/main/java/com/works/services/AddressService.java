package com.works.services;

import com.works.entities.Address;
import com.works.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    final AddressRepository addressRepository;

    public Address addressSave(Address address) {
        return addressRepository.save(address);
    }

}
