package com.springboot.thymeleafdemo.service;

import com.springboot.thymeleafdemo.entity.Customer;
import com.springboot.thymeleafdemo.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;


@Service
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final HashService hashService;

    public CustomerService(CustomerMapper customerMapper, HashService hashService) {
        this.customerMapper = customerMapper;
        this.hashService = hashService;
    }

    public  boolean iscustomernameAvailable (String username)
    {
        return customerMapper.getCustomer(username) == null;
    }
    public  int createCustomer (Customer customer){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(customer.getPassword(), encodedSalt);
        return customerMapper.insert(new Customer(null,customer.getFirstName(),customer.getLastName(),customer.getPhoneNumber(),customer.getEmail(),customer.getUser_name(),hashedPassword,encodedSalt));

    }
}


