package com.tp5.customers.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp5.customers.Models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	
}
