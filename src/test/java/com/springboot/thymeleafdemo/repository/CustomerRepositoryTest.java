package com.springboot.thymeleafdemo.repository;

import com.springboot.thymeleafdemo.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Sql(scripts={"classpath:db/dev/insert-customer.sql"})
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;


    Customer customer;

    @BeforeEach
    void setUp() {

        customer = new Customer();
        customer.setFirstName("john");
        customer.setLastName("Doe");
        customer.setEmail("doe@gmail.com");
        customer.setPhoneNumber("0902345675098");
        customer.getPassword();
        customer.getPassword();
        customer.getSalt();
    }

    @Test
    void saveCustomerTest() {

        customerRepository.save(customer);
        System.out.println("customer object after saving" + customer);

        Customer dbCustomer = customerRepository.findById(customer.getId()).get();


        assertThat(dbCustomer.getFirstName()).isEqualTo(customer.getFirstName());
        assertThat(dbCustomer.getLastName()).isEqualTo(customer.getLastName());
        assertThat(dbCustomer.getEmail()).isEqualTo(customer.getEmail());
        assertThat(dbCustomer.getPhoneNumber()).isEqualTo(customer.getPhoneNumber());

    }

    @Test
    void findByIdTest() {
        Customer newCustomer = customerRepository.findById(1l).get();
        assertEquals("Leslie", newCustomer.getFirstName());
        assertEquals("Andrews", newCustomer.getLastName());
        assertEquals(1, newCustomer.getId());

    }

    @Test
    void UpdateCustomerTest() {
        Customer Customer = customerRepository.findById(2l).get();

        System.out.println("updated customer" + Customer);
        customerRepository.save(customer);

        assertThat(Customer.getFirstName()).isEqualTo("Emma");
        assertThat(Customer.getLastName()).isEqualTo("Baumgarten");
        assertThat(Customer.getEmail()).isEqualTo("emma@demo.com");
        assertThat(Customer.getPhoneNumber()).isEqualTo(8098765643l);

        Customer.setFirstName("Tobi");
        customerRepository.save(Customer);
        Customer savedCustomer = customerRepository.findById(2l).get();

        System.out.println("customer has been updated" + Customer);
        customerRepository.save(Customer);

        assertThat(savedCustomer.getFirstName()).isEqualTo("Tobi");
        assertThat(savedCustomer.getLastName()).isEqualTo("Baumgarten");
        assertThat(savedCustomer.getEmail()).isEqualTo("emma@demo.com");
        assertThat(savedCustomer.getPhoneNumber()).isEqualTo(8098765643l);

    }

    @Test
    void deleteCustomerTest() {
        Customer mycustomer = customerRepository.findById(2l).get();
        System.out.println("customer to be delete" + mycustomer);

        assertThat(mycustomer.getFirstName()).isEqualTo("Emma");
        assertThat(mycustomer.getLastName()).isEqualTo("Baumgarten");
        assertThat(mycustomer.getEmail()).isEqualTo("emma@demo.com");
        assertThat(mycustomer.getPhoneNumber()).isEqualTo(8098765643l);
        customerRepository.save(mycustomer);


        System.out.println("customer has been deleted" + mycustomer);

        customerRepository.delete(mycustomer);

        assertThat(mycustomer.getFirstName()).isEqualTo("Emma");
        assertThat(mycustomer.getLastName()).isEqualTo("Baumgarten");
        assertThat(mycustomer.getEmail()).isEqualTo("emma@demo.com");
        assertThat(mycustomer.getPhoneNumber()).isEqualTo(8098765643l);
    }

    @Test
    void findAllById() {
       List<Customer> customerList = customerRepository.findAll();
       assertThat(customerList.size()).isEqualTo(5);
        for (Customer c: customerList)
            System.out.println(c);


    }

}

