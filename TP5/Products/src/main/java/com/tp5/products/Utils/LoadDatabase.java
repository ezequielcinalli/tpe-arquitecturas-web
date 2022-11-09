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
  			var pro1 = new Products("Yerba",800.00);
            var pro2 = new Products("Harina",300.00);
            var pro3 = new Products("Arroz",300.00);
            var pro4 = new Products("Fideos",200.00);
            var pro5 = new Products("Salchichas",500.00);
            var pro6 = new Products("Cerveza",400.00);
            var pro7 = new Products("Atun",500.00);
            var pro8 = new Products("Mayonesa",500.00);
            var pro9 = new Products("Aceite",600.00);
            var pro10 = new Products("Alfajor",100.00);

			log.info("Preloading " + productRepository.save(pro1));
			log.info("Preloading " + productRepository.save(pro2));
			log.info("Preloading " + productRepository.save(pro3));
			log.info("Preloading " + productRepository.save(pro4));
			log.info("Preloading " + productRepository.save(pro5));
			log.info("Preloading " + productRepository.save(pro6));
			log.info("Preloading " + productRepository.save(pro7));
			log.info("Preloading " + productRepository.save(pro8));
			log.info("Preloading " + productRepository.save(pro9));
			log.info("Preloading " + productRepository.save(pro10));
			
        };
    }
}