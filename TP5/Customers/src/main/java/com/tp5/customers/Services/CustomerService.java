package com.tp5.customers.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp5.customers.Dtos.CustomerAddDto;
import com.tp5.customers.Dtos.CustomerUpdateDto;
import com.tp5.customers.Models.Customer;
import com.tp5.customers.Repositories.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {
	
    @Autowired
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository){
        this.repository = repository;
    }
    
    public Iterable<Customer> findAll(){
        return repository.findAll();
    }
    
       public Optional<Customer> findById(Integer id){
        return repository.findById(id);
    }
    
    public Customer save(CustomerAddDto Customer){
        return repository.save(new Customer(Customer.name));
    }
    
    public Customer update(CustomerUpdateDto Customer, Integer ID){
        Customer oldCustomer = findById(ID).get();
        oldCustomer.setName(Customer.name);
        return repository.save(oldCustomer);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
