package com.vacunateapp.vaccine.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "vaccine")
@Data
@NoArgsConstructor
public class Vaccine implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "VACCINE", length = 256)
	private String name;
	
	@Column(name = "AMOUNT")
	private Integer amount;

}
