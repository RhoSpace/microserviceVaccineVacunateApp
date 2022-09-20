package com.vacunateapp.vaccine.services;

import org.springframework.http.ResponseEntity;

import com.vacunateapp.vaccine.exceptions.AppInternalServerErrorException;
import com.vacunateapp.vaccine.dto.VaccineDto;
import com.vacunateapp.vaccine.entities.Vaccine;
import com.vacunateapp.vaccine.exceptions.AppNotFoundException;


public interface VaccineService {

		public ResponseEntity<?> findByIdVaccine(Long id) throws AppNotFoundException;

	    public ResponseEntity<?> updateVaccine(Long id, VaccineDto dto) throws AppNotFoundException, AppInternalServerErrorException;
	    
	    public Vaccine findById(Long id) throws AppNotFoundException;

}
