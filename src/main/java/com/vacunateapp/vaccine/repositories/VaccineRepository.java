package com.vacunateapp.vaccine.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vacunateapp.vaccine.entities.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long>{

    @Query("SELECT e FROM Vaccine e WHERE e.id = ?1")
    Optional<Vaccine> findByIdOptional(Long id);
}
