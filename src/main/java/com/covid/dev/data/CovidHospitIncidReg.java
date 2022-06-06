package com.covid.dev.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "covid_hospit_incid_reg")
@Data
public class CovidHospitIncidReg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_generator")
	private Long id;
	private Date jour;
	private String nomReg;
	private Integer numReg;
	@Column(name = "incid_rea")
	private String incidRea;
}
