package com.registry.repository;

import com.registry.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    // No custom queries needed here. Spring Boot provides the basic CRUD automatically.
}
