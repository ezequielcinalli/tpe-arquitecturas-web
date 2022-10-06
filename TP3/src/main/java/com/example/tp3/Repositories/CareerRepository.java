package com.example.tp3.Repositories;

import com.example.tp3.Models.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {
}
