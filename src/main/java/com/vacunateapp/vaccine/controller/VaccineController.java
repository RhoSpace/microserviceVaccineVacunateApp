package com.vacunateapp.vaccine.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacunateapp.vaccine.exceptions.AppInternalServerErrorException;
import com.vacunateapp.vaccine.exceptions.AppNotFoundException;
import com.vacunateapp.vaccine.services.VaccineService;
import com.vacunateapp.vaccine.dto.VaccineDto;


@RestController
@RequestMapping("api/vaccine")
@CrossOrigin("*")
public class VaccineController {

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdVaccine(@PathVariable Long id) throws AppNotFoundException{
        return vaccineService.findByIdVaccine(id);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateVaccine(@PathVariable Long id, @RequestBody VaccineDto dto) throws AppInternalServerErrorException, AppNotFoundException {
        return vaccineService.updateVaccine(id, dto);
    }
}
