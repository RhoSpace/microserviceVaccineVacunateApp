package com.vacunateapp.vaccine.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
public class VaccineDto implements Serializable{

	@JsonProperty(value = "name", index = 1)
	private String name;

	@JsonProperty(value = "amount", index = 2)
	private Integer amount;
}
