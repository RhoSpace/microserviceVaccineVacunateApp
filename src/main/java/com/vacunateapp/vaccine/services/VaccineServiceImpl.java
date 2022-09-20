package com.vacunateapp.vaccine.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vacunateapp.vaccine.dto.VaccineDto;
import com.vacunateapp.vaccine.entities.Vaccine;
import com.vacunateapp.vaccine.exceptions.AppInternalServerErrorException;
import com.vacunateapp.vaccine.exceptions.AppNotFoundException;
import com.vacunateapp.vaccine.repositories.VaccineRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class VaccineServiceImpl implements VaccineService {

	private final VaccineRepository vaccineRepository;

	public VaccineServiceImpl(VaccineRepository vaccineRepository) {
		this.vaccineRepository = vaccineRepository;
	}

	@Override
	public Vaccine findById(Long id) throws AppNotFoundException {
		log.info("findById: {}", id);
		return vaccineRepository.findByIdOptional(id)
				.orElseThrow(() -> new AppNotFoundException("No Encontre la vacuna con id: " + id));
	}

	@Override
	public ResponseEntity<?> findByIdVaccine(Long id) throws AppNotFoundException {

		Vaccine vaccineBd = findById(id);

		return ResponseEntity.status(HttpStatus.OK).body(vaccineBd);
	}

	@Override
	public ResponseEntity<?> updateVaccine(Long id, VaccineDto dto)
			throws AppNotFoundException, AppInternalServerErrorException {
		try {
			Vaccine vaccineBd = vaccineRepository.findById(id).orElse(null);
			findById(id);

			Vaccine newVaccine = new Vaccine();
			newVaccine.setId(id);
			newVaccine.setName(dto.getName());
			newVaccine.setAmount(vaccineBd.getAmount() + dto.getAmount());

			if (newVaccine.getAmount() >= 0) {
				Vaccine updateVaccine = vaccineRepository.save(newVaccine);

				return ResponseEntity.status(HttpStatus.OK).body(updateVaccine);
			}else{
			throw new AppInternalServerErrorException("No quedan vacunas");
		}
		} catch (AppNotFoundException e) {
			e.printStackTrace();
			throw new AppNotFoundException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppInternalServerErrorException("Error al actualizar la cantidad de vacunas");
		}
	}

}
