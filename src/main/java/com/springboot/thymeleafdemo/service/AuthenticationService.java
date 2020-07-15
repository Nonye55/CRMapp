package com.springboot.thymeleafdemo.service;

import com.springboot.thymeleafdemo.entity.Customer;
import com.springboot.thymeleafdemo.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService implements AuthenticationProvider {
    private CustomerMapper customerMapper;
    private HashService hashService;

@Autowired
    public AuthenticationService(CustomerMapper customerMapper, HashService hashService) {
        this.customerMapper = customerMapper;
        this.hashService = hashService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();


        Customer customer = customerMapper.getCustomer(username);

            if (customer != null) {
                String encodedSalt = customer.getSalt();
                String hashedPassword = hashService.getHashedValue(password, encodedSalt);
                if (customer.getPassword().equals(hashedPassword)) {
                    return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
                }
            }
            return null;
        }
        @Override
        public boolean supports(Class<?> authentication) {
            return authentication.equals(UsernamePasswordAuthenticationToken.class);
        }

}