package com.example.tp3.Repositories;

import com.example.tp3.Models.Career;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {
	
	@Query("SELECT c FROM Career c ORDER BY c.name")
    public List<Career> careersSorteredByName();
	
}
