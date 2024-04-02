package com.works.services;

import com.works.entities.Customer;
import com.works.entities.Role;
import com.works.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService implements UserDetailsService {

    final CustomerRepository customerRepository;
    final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findByEmailEqualsIgnoreCase(username);
        if(customerOptional.isPresent()) {
            Customer c = customerOptional.get();
            return new User(
                c.getEmail(),
                c.getPassword(),
                c.getEnable(),
                true,
                true,
                true,
                parseRole(c.getRoles())
            );
        }
        throw new UsernameNotFoundException("User Not Found!");
    }

    private Collection<? extends GrantedAuthority> parseRole(List<Role> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        for ( Role role : roles ) {
            list.add( new SimpleGrantedAuthority(role.getName()));
        }
        return list;
    }

    public Customer register(Customer customer)  {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailEqualsIgnoreCase(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            return null;
        }
        String newPass = passwordEncoder.encode( customer.getPassword() );
        customer.setPassword( newPass );
        customerRepository.save(customer);
        return customer;
    }


}
