package com.example.tp3.Utils;

import com.example.tp3.Models.City;
import com.example.tp3.Repositories.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
        CommandLineRunner initDatabase(CityRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new City("City1")));
            log.info("Preloading " + repository.save(new City("City2")));
        };
    }
}