package com.tp5.products.Utils;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tp5.products.Models.Product;
import com.tp5.products.Repositories.ProductRepository;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
    CommandLineRunner initDatabase(ProductRepository ProductRepository) {
    	return args -> {
  			var pro1 = new Product("Yerba",800.00F);
            var pro2 = new Product("Harina",300.00F);
            var pro3 = new Product("Arroz",300.00F);
            var pro4 = new Product("Fideos",200.00F);
            var pro5 = new Product("Salchichas",500.00F);
            var pro6 = new Product("Cerveza",400.00F);
            var pro7 = new Product("Atun",500.00F);
            var pro8 = new Product("Mayonesa",500.00F);
            var pro9 = new Product("Aceite",600.00F);
            var pro10 = new Product("Alfajor",100.00F);

			log.info("Preloading " + ProductRepository.save(pro1));
			log.info("Preloading " + ProductRepository.save(pro2));
			log.info("Preloading " + ProductRepository.save(pro3));
			log.info("Preloading " + ProductRepository.save(pro4));
			log.info("Preloading " + ProductRepository.save(pro5));
			log.info("Preloading " + ProductRepository.save(pro6));
			log.info("Preloading " + ProductRepository.save(pro7));
			log.info("Preloading " + ProductRepository.save(pro8));
			log.info("Preloading " + ProductRepository.save(pro9));
			log.info("Preloading " + ProductRepository.save(pro10));
			
        };
    }
}