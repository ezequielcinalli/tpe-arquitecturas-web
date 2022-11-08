package com.tp5.customers.Utils;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tp5.customers.Models.Customer;
import com.tp5.customers.Repositories.CustomerRepository;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository) {
    	return args -> {
  			var cus1 = new Customer("Pepe 1");
			var cus2 = new Customer("Pepe 2");
			var cus3 = new Customer("Pepe 3");
			var cus4 = new Customer("Pepe 4");
			var cus5 = new Customer("Pepe 5");
			var cus6 = new Customer("Pepe 6");
			var cus7 = new Customer("Pepe 7");
			var cus8 = new Customer("Pepe 8");
			var cus9 = new Customer("Pepe 9");
			var cus10 = new Customer("Pepe 10");
			log.info("Preloading " + customerRepository.save(cus1));
			log.info("Preloading " + customerRepository.save(cus2));
			log.info("Preloading " + customerRepository.save(cus3));
			log.info("Preloading " + customerRepository.save(cus4));
			log.info("Preloading " + customerRepository.save(cus5));
			log.info("Preloading " + customerRepository.save(cus6));
			log.info("Preloading " + customerRepository.save(cus7));
			log.info("Preloading " + customerRepository.save(cus8));
			log.info("Preloading " + customerRepository.save(cus9));
			log.info("Preloading " + customerRepository.save(cus10));
			
        };
    }
}