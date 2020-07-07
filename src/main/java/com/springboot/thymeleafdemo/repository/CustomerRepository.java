package com.springboot.thymeleafdemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.thymeleafdemo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByfirstName(String name);

//	Optional<Customer> findById(Long aLong);
}
